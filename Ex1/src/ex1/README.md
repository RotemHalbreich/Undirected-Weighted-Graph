# Ex1:

Object Oriented Programming (Ariel University - Computer science department):

## This project deals with the subject of "Graph Theory" focusing on undirectional weighted graph.
## The project assembeled of 3 different classes implemented from 3 different interfaces:


1.	NodeInfo:
------------------------------------------------------------------------------------------
	An inner private class representing the graph's vertices:
	
	Including methods:
	A. getKey() - Get a unique key ID for each vertex.
	B. getInfo() - Get the info of a vertex as a String, marking whether the vertex was "VISITED" or "UNVISITED".
	C. getTag() - Get the tag of a vertex marking the weight count of the previous vertices to the current vertex included.
	D. setTag() - Set the tag of a vertex.
	E. compareTo() - A function for tags comparison (weight).


2.	WGraph_DS:
------------------------------------------------------------------------------------------
	Represents a graph assembeled of vertices:
	In this class I chose using the HashMap data structure for its fast running time O(1).
	My implementation is based on HashMap of vertices linked with a unique key for each vertex,
 	and HashMap of edges which links a vertex by a unique key to another vertex including
  	the weight of the edge between them, using HashMap inside HashMap.
	
	Including methods:
	A. getNode() - Get a vertex by a unique key.
	B. hasEdge() - Check if there's an edge between two vertices.
	C. getEdge() - Gets an edge between two vertices represented by weight.
	D. addNode() - Adds a vertex to the graph.
	E. connect() - Connect between two vertices.
	F. getV() - Get the neighbors of the vertex as a collection.
	G. getV(node_id) - Get the value of the graph's vertices as a collection.
 	H. removeNode() - Removes a vertex from the graph.
	I. removeEdge() - Removes an edge from the graph.
  	J. nodeSize() - returns the number of vetices in the graph.
 	K. edgeSize() - returns the number of edges in the graph.
	L. getMC() - returns the number of changes made to the graph.

3.  WGraph_Algo: 
------------------------------------------------------------------------------------------
	Represents the algorithms we apply on the graph:
 	In this class I use mostly Dijkstra & BFS algorithms for implementing the algorithms below:
	
	A. init() - Initializes the graph.
	B. getGraph() - Returns an undirectional weighted graph.
	C. copy() - Computes a deep copy of the graph.
	D. isConnected() - Checks if all the vertices of the graph are connected by edges.
	E. shortestPathDist() - Returns the shortest path distance between two vertices of the graph (minimum weight). 
	F. shortestPath() - Returns the shortest path route between two vertices of the graph (minimum weight).
  	G. save() - Saves a graph to a file.
 	H. load() - Loads a graph from a file.
