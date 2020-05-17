<h1>c18360943 Assignment</h1> 
Name : Sean Delaney 
Student number : c183690943
This is my final music visuals assignment project. 

<h2>About the project :</h2>

In my project, I created a few different 2D visual effects to look at while listening to music. I used some different colors for different visuals and used different methods for making the visuals look nice. I used the following visuals :

1) 2 circles and an ellipse dancing / breathing to the amplitude of the music and changing color also.
2) A mirrored , half-screen Amplitude graph.
3) A 2 way mirrored (up/down and right/left) frequency graph.
4) A circle whos radius is equal to that of the frequency at 512 different bands.
5) A few lines and a rectangle that give the user an effect pf being in a cube and change colour to the amplitude of the audio.

<h2>Instructions : </h2>

There are a few instructions for interactive parts of my assignment, they are all keyboard activated and are displayed when the program runs. They are :

1) x : This closes the AudioPlayer and stops the minim.
2) c : Thus toggles the circles visual on/off the screen.
3) f : This toggles the frequency circle on/off the screen.
4) v : This toggles the Amplitude visualiser on/off the screen.
5) w : This toggles the frequency visuailiser on/off the screen.
6) t : This moves the amplitude visualiser from the bottom of the screen to the top or vice/versa.
7) g : This toggles the cube visual on/off.
8) SPACE : This is to play/pause the audio.

<h2>How it works : </h2> 

<h3>For the 2 circles and ellipse :</h3>
The outter circle has a radius that is mapped to change with the amplitude of the audio.
I multiplied the x-coordinate by 3 and the y coordinate by 4 to give it a more oval shape.
The inner circle is the same concept only I have kept the x and y cooridinates uniform.
The ellipse is just set to move to 3000 time the amplitude and I have mapped it to be the full width of the window.

<h3>For the frequencyCircle :</h3>
I learned how to do this from a youtube video that was explaining how to do it in p5 in javascript so it ended up being more complicated than I had anticipated.
I mapped an angle between 0  and the size of my LinkedList containing all of the frequency values between 0 and the size of that LinkedListto between 0 and 360.
I then the radius which was the currect frequency value between 0 and 256 to between 40 and 200.
I then did the usual match calculations : x = radius * cos(angle) and y = radius * sin(angle)
and created a vertex on that x and y point.
I also used the removeFirst() function on my linkedList contaning the frequency values so once I had 512 values it would look back around the start of the linkedList.

<h3>For the cube effect : </h3>
This was my most simple visual. I simply mapped out a rectangle on the screen that looked the optimal size to me and then drew lines from the corners of the screen to the nearest point on the rectangle.
I haven't menetioned before but for the colors, I mapped a hue that mapped the current amplitude * 1000 between -400 and 300 to between 0 and 360. Then i just used different variations of that hue for different visuals.

<h3> For the amplitude visualiser : </h3>
For this I just mapped a y value of the current amplitude of the song to between 0 and 1 to a maximum of between half the screenHeight and 0.
To create a mirror on the other half of the screen I just inverted the coordinates and did the same to put the visualiser at the top of the screen.
The x value was a value between 0 and the size of the amplitude history. I cleared the amplitude history every time it got to the size of half the width of the screen.

<h3>For the frequency visualiser : </h3> 
This was pretty much the same thing as the amplitude visualiser only I used the frequency history for obvious reasons. I mapped the y values however to a maximum of between 0 and 1/4 the height of the screen to keep it from being too big.


<h3>What am I proud of in this assignment : </h3> 
I am very proud of what I created in this assignment. When I first began working on it a few weeks back I created a few different ideas just to try and test them out. They were initially very bad and I actually didn't even bother uploading them to github becauuse they were just for practice. I kept on geting errors in my draw function and the likes that I had no idea how to fix. Despite that, I kept working and came up with something that I actuallly quite enjoy looking at. I know it might be a simple enough project but for the first time ever I found myself showing what I had coded to my friends and family because usually the work I do they wouldn't understand but now I had something that looked like a real application that I could show off. I think that is the thing that I am most proud of. This is the first time I have coded something where the final product looks somewhat like a real app that people use everyday. I will definitely be expanding on this program in the future!.

<h3>My Youtube video : </h3> 
https://www.youtube.com/watch?v=OsAtdRGToW4&t=0s

