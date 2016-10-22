#include "Maze.h"
#include "Position.h"

#include <iostream>
#include <cassert>
#include <iomanip>

// using namespace std;

Maze::Maze()
{ 
   start = Position(1,1);
   exit = Position(MAZEMAX-1,MAZEMAX-1);
   size= MAZEMAX;
   try {
      M = new state *[size];
   }
   catch(bad_alloc) {
      cerr << "Unable to allocate array of state pointers";
      std::exit(1);
   }
   for(int i = 0; i < size; i++) {
      try {
	 M[i] = new state[size];
      }
      catch (bad_alloc) {
	 cerr << "Unable to allocate row of state values";
	 std::exit(1);
      }
      for (int j = 0; j < size; j++)
	 M[i][j] = WALL;
   }   
}   

Maze::Maze(int max)
{
   int i,j;
   size = max;
   start = Position(1,1); // Upper left corner position
   exit = Position(size-2,size-2); // lower right corner position
   try {
      M = new state *[size];
   }
   catch(bad_alloc) {
      cerr << "Unable to allocate array of state pointers";
      std::exit(1);
   }
   for(int i = 0; i < size; i++) {
      try {
	 M[i] = new state[size];
      }
      catch (bad_alloc) {
	 cerr << "Unable to allocate row of state values";
	 std::exit(1);
      }
      for (j = 0; j < size; j++)
	 M[i][j] = WALL;
   }   
}

Maze::Maze(Position s, Position e)
{
   int i,j;
   size = MAZEMAX;
   start = s;
   exit = e;
   try {
      M = new state *[size];
   }
   catch(bad_alloc) {
      cerr << "Unable to allocate array of state pointers";
      std::exit(1);
   }
   for(int i = 0; i < size; i++) {
      try {
	 M[i] = new state[size];
      }
      catch (bad_alloc) {
	 cerr << "Unable to allocate row of state values";
	 std::exit(1);
      }
      for (j = 0; j < size; j++)
	 M[i][j] = WALL;
   }   
}

Maze::Maze(Position s, Position e, int n)
{
   int i,j;
   size = n;
   start = s;
   exit = e;
   try {
      M = new state *[size];
   }
   catch(bad_alloc) {
      cerr << "Unable to allocate array of state pointers";
      std::exit(1);
   }
   for(int i = 0; i < size; i++) {
      try {
	 M[i] = new state[size];
      }
      catch (bad_alloc) {
	 cerr << "Unable to allocate row of state values";
	 std::exit(1);
      }
      for (j = 0; j < size; j++)
	 M[i][j] = WALL;
   }   
}


state  Maze::getState(const Position &P) const
{
   return M[P.getRow()][P.getCol()];
}

void Maze::display(ostream &out) const
{
   out << '\n';
   for (int i=0; i < size;i++) {
      for (int j=0; j < size; j++)
	 if (Position(i,j) == start)
	    cout << 's';
         else if (Position(i,j) == exit)
	    cout << 'e';
	 else if (M[i][j] == WALL)
	    out << '*';
         else
	    out << ' ';
      out << '\n';
   }
   out << '\n';
}

void Maze::setState(const Position &P, state s)
{
   int i = P.getRow();
   int j = P.getCol();
   assert(1 <= i && i <= size && 1 <= j && j <= size);
   M[i][j] = s;
}

bool Maze::findExit(Position **Predecessor)
{
   // Fill in the missing code
   // Returns true if a start-to-exit path has been found
   // and this path will be a shortest possible escape path
   // Note: check out the new definition of the direction enumeration
   //       In particular, the new direction None
   //       You may now step through directions correctly using
   //       for(direction d = DOWN; d != None; d++) ...
}

void Maze::printPath(Position **pred)
{
   recursivePrintPath(start,exit,pred);
}

void recursivePrintPath(Position first, Position target, Position **Pred)
{
   if (target == first)
      cout << target << endl;
   else {
      recursivePrintPath(first,Pred[target.getRow()][target.getCol()],Pred);
      cout << target << endl;
   }
}

void Maze::initialize() // Assumes size already set
{
   int i, j;
   cout << "All position indices k must satisfy 1 <= k < = " << (size-2) << '\n';
   cout << "Enter the start position:\n";
   cin >> start;
   cout << "Enter the exit position:\n";
   cin >> exit;
   cout << "Please enter column indices for each row\n";

   for (i = 1; i < size-1; i++) {
      cout << "row " << i << ": ";
      cin >> j;
      while (j > 0){
	 M[i][j] = OPEN;
	 cin >> j;
      };
   }
   cout << endl;
   if (getState(start) != OPEN) {
      cout << "start position must be open; will fix that now\n";
      M[start.getRow()][start.getCol()] = OPEN;
   }
   if (getState(exit) != OPEN)
      cout << "Boy, are you mean, setting the exit in the wall.  Poor rat!\n";
   cout << "\nMaze entry complete" << endl;
}
