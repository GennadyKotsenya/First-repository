package day17;

public class Task2 {
    public static void main(String[] args) {

//        ChessBoard chessBoard = new ChessBoard(new ChessPiece[][]{
//                {ChessPiece.ROOK_BLACK, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.ROOK_BLACK, ChessPiece.KING_BLACK, ChessPiece.EMPTY},
//                {ChessPiece.EMPTY, ChessPiece.ROOK_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.PAWN_BLACK, ChessPiece.PAWN_BLACK, ChessPiece.EMPTY, ChessPiece.PAWN_BLACK},
//                {ChessPiece.PAWN_BLACK, ChessPiece.EMPTY, ChessPiece.KNIGHT_BLACK, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.PAWN_BLACK, ChessPiece.EMPTY},
//                {ChessPiece.QUEEN_BLACK, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.BISHOP_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY},
//                {ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.BISHOP_BLACK, ChessPiece.PAWN_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY},
//                {ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.BISHOP_WHITE, ChessPiece.PAWN_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY},
//                {ChessPiece.PAWN_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.QUEEN_WHITE, ChessPiece.EMPTY, ChessPiece.PAWN_WHITE, ChessPiece.EMPTY, ChessPiece.PAWN_WHITE},
//                {ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.ROOK_WHITE, ChessPiece.KING_WHITE, ChessPiece.EMPTY,}
//        });


        ChessPiece[][] chessPieces = new ChessPiece[8][8];

        for (int i = 0; i < chessPieces.length; i++) {
            for (int j = 0; j < chessPieces[i].length; j++) {
                chessPieces[i][j] = ChessPiece.EMPTY;
            }
        }
        chessPieces[0][0] = ChessPiece.ROOK_BLACK;
        chessPieces[0][5] = ChessPiece.ROOK_BLACK;
        chessPieces[0][6] = ChessPiece.KING_BLACK;

        chessPieces[1][1] = ChessPiece.ROOK_WHITE;
        chessPieces[1][4] = ChessPiece.PAWN_BLACK;
        chessPieces[1][5] = ChessPiece.PAWN_BLACK;
        chessPieces[1][7] = ChessPiece.PAWN_BLACK;

        chessPieces[2][0] = ChessPiece.PAWN_BLACK;
        chessPieces[2][2] = ChessPiece.KNIGHT_BLACK;
        chessPieces[2][6] = ChessPiece.PAWN_BLACK;

        chessPieces[3][0] = ChessPiece.QUEEN_BLACK;
        chessPieces[3][3] = ChessPiece.BISHOP_WHITE;

        chessPieces[4][3] = ChessPiece.BISHOP_BLACK;
        chessPieces[4][4] = ChessPiece.PAWN_WHITE;

        chessPieces[5][4] = ChessPiece.BISHOP_WHITE;
        chessPieces[5][5] = ChessPiece.PAWN_WHITE;

        chessPieces[6][0] = ChessPiece.PAWN_WHITE;
        chessPieces[6][3] = ChessPiece.QUEEN_WHITE;
        chessPieces[6][5] = ChessPiece.PAWN_WHITE;
        chessPieces[6][7] = ChessPiece.PAWN_WHITE;

        chessPieces[7][5] = ChessPiece.ROOK_WHITE;
        chessPieces[7][6] = ChessPiece.KING_WHITE;


        ChessBoard chessBoard = new ChessBoard(chessPieces);

        chessBoard.print();
    }
}
