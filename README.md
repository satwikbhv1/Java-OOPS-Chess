# Java OOP Chess

Chess in Java with Swing. I started with everything in one big `GUI.java` file and slowly pulled the rules into their own classes so the board UI isn’t doing all the work.

**Java 21** and **Maven**.

## Run

```bash
mvn compile exec:java
```

Main class: `com.schess.ChessFrame`.

## Playing

Click your piece — legal squares highlight. Click a highlighted square to move (click the same piece again to cancel). Pawns promote to a queen on the last rank. Captured pieces show above and below the board. **New Game** starts over. Checkmate and stalemate show in the status bar and the board stops taking moves.

White is at the bottom (ranks 8–1, files a–h).

## What works

Standard moves for all pieces, captures, turns, castling both sides, check/checkmate/stalemate, you can’t move into check, king highlight when in check, rank/file labels, legal-move highlights, captured-piece strips.

## Not done yet

- En passant
- Underpromotion (promotion is queen only for now)

Might add later: undo, draw rules, timer, etc...

## Project layout

```
src/main/java/com/schess/
  ChessFrame.java          — entry point
  ui/                      — BoardPanel, CapturedPanel, ChessController, icons
  game/                    — Game, Board, MoveValidator, moves, castling
  pieces/                  — Piece types (King, Pawn, …)
src/main/resources/images/ — piece artwork (12 files)
```
