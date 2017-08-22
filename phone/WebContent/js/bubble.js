/*

    MIT License

    Copyright (c) 2016 Marcello A. Sabino

    Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation 
    files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, 
    modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom 
    the Software is furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all copies or substantial portions of the 
    Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
    INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
    IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
    WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR 
    THE USE OR OTHER DEALINGS IN THE SOFTWARE.

    Allows bubbles to be created and be moved around randomly in any part of the HTML DOM with Javascript and JQuery.

    Author: Marcello Sabino
    Date:   December 13, 2016
*/

/* the node that bubbles will appear inside */
var insideNode = "body";    // type this as you would in css: #id, .class, element
/* the total amount of bubbles to appear inside the node */
var totalBubbles = 16;
/* maximum time to move the bubble from x to y in milliseconds */
var maxTimeToMove = 1200;
/* minimum time to move the bubble from x to y in milliseconds */
var minTimeToMove = 600;

$(document).ready(function() {
    if (totalBubbles == 0)  // just make sure there's at least one bubble.
        totalBubbles = 1;

    // did you decide to add a border to this bubble?
    var borderWidth = $(".bubble").css("border-left-width").slice(0, -2) * 2;

    boundsX = $(insideNode).width() - $(".bubble").width() - borderWidth;
    boundsY = $(insideNode).height() - $(".bubble").height() - borderWidth;

    /* restarts the animation when the page has been resized */
    function restartAnimation() {
        boundsX = $(insideNode).width() - $(".bubble").width() - borderWidth;
        boundsY = $(insideNode).height() - $(".bubble").height() - borderWidth;
        $(".bubble").stop(true); // stop the animations
        moveBubbles();   // restart the animations within the new bounds
    };

    // creates the bubbles
    for (i = 0; i < totalBubbles - 1; i++) {
        $(insideNode).prepend("<div class='bubble'> </div>");
    }

    // start at a random x coordinate
    $(".bubble").css("left", Math.floor(Math.random() * boundsX) + "px");

    // resize! we should update the bounds!
    $(window).resize(restartAnimation);
    moveBubbles();
});

/* moves each individual bubble around */
function moveBubbles() {
    var curr;
    for (var i = 0; i < totalBubbles; i++) {
        curr = document.getElementsByClassName("bubble")[i];
        $(curr).animate(
            {
                left: Math.floor(Math.random() * boundsX),
                top: Math.floor(Math.floor(Math.random() * (boundsY)))
            },
            Math.floor((Math.random() * maxTimeToMove) + minTimeToMove),
            function() {
                moveBubbles();
            });
    }
}