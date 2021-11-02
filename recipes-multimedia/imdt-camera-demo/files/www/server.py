#
# IMDT Camera Demo
#
# Copyright (c) 2021 IMD Technologies. All rights reserved.
#

from http.server import SimpleHTTPRequestHandler
import socketserver
from enum import Enum, unique
from os import listdir
from os.path import isfile, join
from os import system
import subprocess

@unique
class Pages(Enum):
    HOME = 0
    STREAM = 1
    SNAPSHOTS = 2

def start_page(handler, title):

    handler.send_response(200)
    handler.send_header("Content-type", "text/html")
    handler.send_header("Cache-Control", "no-store")
    handler.end_headers()
    handler.flush_headers()

    handler.wfile.write('<!doctype html>\n'.encode())
    handler.wfile.write('<html lang="en">\n'.encode())
    handler.wfile.write('<head>\n'.encode())
    handler.wfile.write('  <meta charset="utf-8">\n'.encode())
    handler.wfile.write('  <meta name="viewport" content="width=device-width, initial-scale=1">\n'.encode())
    handler.wfile.write('  <meta name="theme-color" content="#000"/>\n'.encode())
    handler.wfile.write('  <link href="/css/bootstrap.min.css" rel="stylesheet">\n'.encode())
    handler.wfile.write('  <link href="/css/camera-demo.css" rel="stylesheet">\n'.encode())
    handler.wfile.write('  <link rel="icon" href="/images/icon.png" sizes="192x192" />\n'.encode())
    handler.wfile.write('  <title>{} - IMD Technologies</title>\n'.format(title).encode())
    handler.wfile.write('</head>\n'.encode())
    handler.wfile.write('<body>\n'.encode())
    handler.wfile.write('  <script src="/js/bootstrap.bundle.min.js"></script>\n'.encode())
    handler.wfile.write('  <script src="/js/jquery-3.6.0.min.js"></script>\n'.encode())
    handler.wfile.write('  <div class="container p-2">\n'.encode())

    return

def navigation(handler, page):

    stream_page_classes = ''
    snapshots_page_classes = ''

    if page == Pages.STREAM:
        stream_page_classes = 'active'

    if page == Pages.SNAPSHOTS:
        snapshots_page_classes = 'active'

    handler.wfile.write('    <nav class="navbar navbar-dark navbar-expand-lg bg-dark mb-2">\n'.encode())
    handler.wfile.write('      <div class="container">\n'.encode())
    handler.wfile.write('        <a class="navbar-brand" href="/">\n'.encode())
    handler.wfile.write('          <img class="navbar-logo" src="/images/logo.svg" alt="IMD Technologies">\n'.encode())
    handler.wfile.write('        </a>\n'.encode())
    handler.wfile.write('        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">\n'.encode())
    handler.wfile.write('          <span class="navbar-toggler-icon"></span>\n'.encode())
    handler.wfile.write('        </button>\n'.encode())
    handler.wfile.write('        <div class="collapse navbar-collapse" id="navbarNav">\n'.encode())
    handler.wfile.write('          <ul class="navbar-nav">\n'.encode())
    handler.wfile.write('            <li class="nav-item">\n'.encode())
    handler.wfile.write('              <a class="nav-link mx-2 {}" href="/stream.html">Video Stream</a>\n'.format(stream_page_classes).encode())
    handler.wfile.write('            </li>\n'.encode())
    handler.wfile.write('	          <li class="nav-item">\n'.encode())
    handler.wfile.write('              <a class="nav-link mx-2 {}" href="/snapshots.html">Snapshots</a>\n'.format(snapshots_page_classes).encode())
    handler.wfile.write('            </li>\n'.encode())
    handler.wfile.write('          </ul>\n'.encode())
    handler.wfile.write('        </div>\n'.encode())
    handler.wfile.write('      </div>\n'.encode())
    handler.wfile.write('    </nav>\n'.encode())

    return



def end_page(handler):
    handler.wfile.write(' </div>\n'.encode())
    handler.wfile.write('</body>\n'.encode())
    return



def display_homepage(handler):
    start_page(handler, 'PICO SoM Camera Demo')
    navigation(handler, Pages.HOME)
    end_page(handler)
    return


def display_stream(handler):

    stream_running = is_stream_running()

    start_button_classes = ''
    stop_button_classes = ''

    if (stream_running):
        start_button_classes = ' active disabled'
    else:
        stop_button_classes = ' active disabled'

    start_page(handler, 'Video Stream')
    navigation(handler, Pages.STREAM)

    handler.wfile.write('    <div class="row">\n'.encode())
    handler.wfile.write('      <div class="column">\n'.encode())
    handler.wfile.write('        <button class="btn btn-success m-2 {}" id="start_stream">Start Stream</button>'.format(start_button_classes).encode())
    handler.wfile.write('        <button class="btn btn-danger m-2 {}" id="stop_stream">Stop Stream</button>\n'.format(stop_button_classes).encode())
    handler.wfile.write('      </div>\n'.encode())
    handler.wfile.write('    </div>\n'.encode())

    handler.wfile.write('    <div class="row">\n'.encode())
    handler.wfile.write('      <div class="column">\n'.encode())
    handler.wfile.write('        <img src="/images/logo.svg" class="m-4 watermark">\n'.encode())
    handler.wfile.write('        <div class="ratio ratio-16x9 mt-2">\n'.encode())
    handler.wfile.write('          <video controls id="video"></video>\n'.encode())
    handler.wfile.write('        </div>\n'.encode())
    handler.wfile.write('      </div>\n'.encode())
    handler.wfile.write('    </div>\n'.encode())

    script = """
<script src="/js/hls.min.js"></script>

<script>

    $("#start_stream").click(function(event) {
        event.preventDefault();
        var posting = $.post( "/start-stream" );
 
        posting.done(function(data) {
            $("#start_stream").addClass("active disabled");
            $("#stop_stream").removeClass("active disabled");

            setTimeout(startVideoStream, 2000);
        });
    });

    function startVideoStream() {
        var video = document.getElementById('video');
        if (Hls.isSupported()) {
            var hls = new Hls();
            hls.loadSource('/stream1/playlist.m3u8');
            hls.attachMedia(video);
            hls.on(Hls.Events.MANIFEST_PARSED,function() {
                console.log('Parsed manifest');
                video.play();
            });
        }
    }

    $("#stop_stream").click(function(event) {
        event.preventDefault();

        var video = document.getElementById('video');
        video.pause();

        var posting = $.post( "/stop-stream" );
 
        posting.done(function(data) {
            $("#stop_stream").addClass("active disabled");
            $("#start_stream").removeClass("active disabled");
        });
    });

</script>
    """

    handler.wfile.write(script.encode())

    if (stream_running):
        handler.wfile.write('<script>setTimeout(startVideoStream, 2000);</script>'.encode())

    end_page(handler)
    return


def display_snapshots(handler):

    stream_running = is_stream_running()

    button_disabled = ''
    if stream_running:
        button_disabled = 'disabled'

    start_page(handler, 'Snapshots')
    navigation(handler, Pages.SNAPSHOTS)

    if stream_running:

        handler.wfile.write('            <div class="alert alert-warning m-2" role="alert">\n'.encode())
        handler.wfile.write('                Please stop the video stream before attempting to use the snapshot utility\n'.encode())
        handler.wfile.write('            </div>\n'.encode())

    handler.wfile.write('    <div class="row">\n'.encode())
    handler.wfile.write('      <div class="column d-flex align-items-center">\n'.encode())
    handler.wfile.write('        <button class="btn btn-primary m-2 imdt-control" id="png_snapshot" {}>Take PNG Snapshot</button>'.format(button_disabled).encode())
    handler.wfile.write('        <button class="btn btn-secondary m-2 imdt-control" id="jpeg_snapshot" {}>Take JPEG Snapshot</button>'.format(button_disabled).encode())
    handler.wfile.write('        <button class="btn btn-danger m-2 imdt-control" id="delete_snapshots" {}>Delete All Snapshots</button>\n'.format(button_disabled).encode())
    handler.wfile.write('        <div id="progress_spinner" class="spinner-border text-light ms-2 invisible" role="status"><span class="visually-hidden">Taking snapshot...</span></div>\n'.encode())
    handler.wfile.write('      </div>\n'.encode())
    handler.wfile.write('    </div>\n'.encode())

    onlyfiles = [f for f in listdir('./snapshots/') if isfile(join('./snapshots/', f))]
    onlyfiles.sort()
    
    handler.wfile.write('    <div class="row row-cols-4" id="gallery">\n'.encode())
    
    for snapshot in onlyfiles:
        handler.wfile.write('    <div class="col thumbnail"><a href="/snapshots/{0}"><img class="m-2 ratio" src="/snapshots/thumbnails/{0}"><p class="m-2 text-center">{0}</p></a></div>\n'.format(snapshot).encode())

    handler.wfile.write('    </div>\n'.encode())

    script = """
<script>
    $("#png_snapshot").click(function(event) {
        event.preventDefault();
        
        $('#progress_spinner').removeClass('invisible');
        $('.imdt-control').attr('disabled', 'disabled');

        var posting = $.post( "/take-png-snapshot" );
 
        posting.done(function(data) {
                filename = JSON.parse(data).filename;
                $('#gallery').append('<div class="col thumbnail"><a href="/snapshots/'+filename+'"><img class="m-2 ratio" src="/snapshots/thumbnails/'+filename+'"><p class="m-2 text-center">'+filename+'</p></a></div>');
                $('#progress_spinner').addClass('invisible');
                $('.imdt-control').removeAttr('disabled');
            });
        });

    $("#jpeg_snapshot").click(function(event) {
        event.preventDefault();

        $('#progress_spinner').removeClass('invisible');
        $('.imdt-control').attr('disabled', 'disabled');

        var posting = $.post( "/take-jpeg-snapshot" );
 
        posting.done(function(data) {
                filename = JSON.parse(data).filename;
                $('#gallery').append('<div class="col thumbnail"><a href="/snapshots/'+filename+'"><img class="m-2 ratio" src="/snapshots/thumbnails/'+filename+'"><p class="m-2 text-center">'+filename+'</p></a></div>');
                $('#progress_spinner').addClass('invisible');
                $('.imdt-control').removeAttr('disabled');
            });
        });

    $("#delete_snapshots").click(function(event) {
        event.preventDefault();

        $('#progress_spinner').removeClass('invisible');
        $('.imdt-control').attr('disabled', 'disabled');

        var posting = $.post( "/delete-snapshots" );
 
        posting.done(function(data) {
                $( ".thumbnail" ).remove();
                $('#progress_spinner').addClass('invisible');
                $('.imdt-control').removeAttr('disabled');
            });
        });
</script>
    """

    handler.wfile.write(script.encode())

    end_page(handler)

    return


def is_stream_running():
    result = system('systemctl is-active imdt-video-stream.service --quiet')
    return (result == 0)

def start_stream(handler):

    system('systemctl start imdt-video-stream.service')

    handler.send_response(200)
    handler.send_header("Content-type", "text/plain")
    handler.end_headers()
    handler.flush_headers()

    return    


def stop_stream(handler):

    system('systemctl stop imdt-video-stream.service')

    handler.send_response(200)
    handler.send_header("Content-type", "text/plain")
    handler.end_headers()
    handler.flush_headers()

    return    

def take_png_snapshot(handler):

    output = subprocess.check_output('/opt/imdt/camera-demo/bin/take-snapshot.sh')

    handler.send_response(200)
    handler.send_header("Content-type", "text/plain")
    handler.end_headers()
    handler.flush_headers()
    handler.wfile.write('{{"filename": "{}"}}'.format(output.decode()).encode())

    return

def take_jpeg_snapshot(handler):

    output = subprocess.check_output('/opt/imdt/camera-demo/bin/take-snapshot-jpeg.sh')

    handler.send_response(200)
    handler.send_header("Content-type", "text/plain")
    handler.end_headers()
    handler.flush_headers()
    handler.wfile.write('{{"filename": "{}"}}'.format(output.decode()).encode())

    return

def delete_snapshots(handler):

    subprocess.check_output('/opt/imdt/camera-demo/bin/delete-snapshots.sh')

    handler.send_response(200)
    handler.send_header("Content-type", "text/plain")
    handler.end_headers()
    handler.flush_headers()

    return


class CommandHandler(SimpleHTTPRequestHandler):

    def do_GET(self):

        if self.path == "/" or self.path == "/index.html":
            display_homepage(self)
            return

        if self.path == "/stream.html":
            display_stream(self)
            return
        
        if self.path == "/snapshots.html":
            display_snapshots(self)
            return

        SimpleHTTPRequestHandler.do_GET(self)

    def do_POST(self):

        if self.path == '/start-stream':
            start_stream(self)
            return

        if self.path == '/stop-stream':
            stop_stream(self)
            return

        if self.path == "/take-png-snapshot":
            take_png_snapshot(self)
            return

        if self.path == "/take-jpeg-snapshot":
            take_jpeg_snapshot(self)
            return

        if self.path == "/delete-snapshots":
            delete_snapshots(self)
            return

        self.send_response(404)
        self.send_header("Content-type", "text/plain")
        self.end_headers()
        self.flush_headers()


if __name__ == "__main__":

    # Setting allow_resue_address to True.
    socketserver.TCPServer.allow_reuse_address = True
    server = socketserver.TCPServer(("", 80), CommandHandler)
    server.serve_forever()
