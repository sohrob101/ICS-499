var pathGridCanvas = document.getElementById('pathGridCanvas');

var scale = 150;
var size = 6;
var x_off = 15;
var y_off = 20;

function drawLinePuzzle() {
    drawStart();
    drawEnd();
    drawTravelGrid();
    drawRequiredPoints(3, 3);
    drawRequiredPoints(1, 5);
    drawRequiredPoints(2, 1);
    drawZones(2, 2, 0);
    drawZones(4, 4, 1);
}

function drawStart() {

}

function drawEnd() {

}

function drawTravelGrid() {
    var mazeGridCanvas = document.getElementById('mazeGridCanvas');
    if (mazeGridCanvas.getContext) {
        var mazeContext = mazeGridCanvas.getContext('2d');
        for (var x = 0; x < scale * size; x += scale) {
            mazeContext.moveTo(x, 0);
            mazeContext.lineTo(x, scale * size);
        }
        for (var y = 0; y < scale * size; y += scale) {
            mazeContext.moveTo(0, y);
            mazeContext.lineTo(scale * size, y);
        }

        mazeContext.strokeStyle = '#161617';
        mazeContext.lineWidth = 40;
        mazeContext.stroke();
    }
}

function drawRequiredPoints(x, y) {
    var pointGridCanvas = document.getElementById('pointGridCanvas');
    if (mazeGridCanvas.getContext) {
        var pointContext = pointGridCanvas.getContext('2d');
        x = (x * scale) + x_off - 10;
        y = (y * scale) + y_off - 10;
        pointContext.fillStyle = "violet";
        pointContext.beginPath();
        pointContext.moveTo(x + 10, y + 0);
        pointContext.lineTo(x + 14, y + 7);
        pointContext.lineTo(x + 21, y + 7);
        pointContext.lineTo(x + 16, y + 13);
        pointContext.lineTo(x + 17, y + 20);
        pointContext.lineTo(x + 10, y + 17);
        pointContext.lineTo(x + 4, y + 20);
        pointContext.lineTo(x + 5, y + 13);
        pointContext.lineTo(x + 0, y + 7);
        pointContext.lineTo(x + 7, y + 6);
        pointContext.lineTo(x + 10, y + 0);
        pointContext.closePath();
        pointContext.fill();
    }
}

function drawZones(x, y, c) {
    var zoneGridCanvas = document.getElementById('zoneGridCanvas');
    var zoneColor = ["black", "white"][c]
    if (mazeGridCanvas.getContext) {
        var zoneContext = zoneGridCanvas.getContext('2d');
        x = (x * scale) - 60 - 30;
        y = (y * scale) - 55 - 30;
        zoneContext.fillStyle = zoneColor;
        zoneContext.beginPath();
        zoneContext.rect(x, y, 60, 60);
        zoneContext.fill();
    }
}