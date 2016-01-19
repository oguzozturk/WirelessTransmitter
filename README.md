# WirelessTransmitterRange

Suppose that there are n laptops each containing a wireless transmitter. 
For each laptop i, following information are known: 
- Position, (xi, yi),  
- Wireless transmission range, ri
That is, we can imagine that the wireless range of laptop i is a circle centered at (xi, yi) 
with radius ri. We say that the laptops i and j can communicate if their wireless ranges overlap. 
Of course, not every laptop can communicate with every other laptop, 
but laptops can send messages by using intermediate laptops as routers. 
Hop distance h(i, j) is defined as the minimum number of intermediate laptops used to send a message from laptop i to laptop j. 
For example, if two laptops can communicate directly, the hop distance between them is 

1. Now, you are asked to do the following:

a) Given a set of n agents with their positions and wireless ranges, design an efficient algorithm to compute the hop-distance from the first laptop to every other reachable laptop. 
If agent i is not reachable from agent j then the hop distance h(i, j) will be set to 0. 
b) Give time and space complexity of algorithm.
c) Input file format as follows. The first line will contain an integer n, which is the number of agents. 
What follows will be the n lines, where the i’th line contains three real numbers xi, yi and ri corresponding to the
x and y coordinate of the i’th laptop, along with its wireless range. All the values will be separated with tabs (\t).  
Output file format as follows. There will be n lines. On the i’th line will be an integer, 
representing the hop distance h(1,i),the minimum number of intermediate laptops necessary for the first agent to communicate with agent i.
