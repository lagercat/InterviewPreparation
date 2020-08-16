public class RotateMatrix {

    // I will assume the Matrix is NxN
    public static <T> void rotate(T[][] matrix) {

        final int N = matrix.length;
        for(int pixelI = 0; pixelI < N / 2; pixelI += 2) {
            for(int pixelJ = 0; pixelJ < N / 2; pixelJ += 2) {
                for(int i = pixelI; i < pixelI + 2 && i < N / 2; ++i) {
                    for(int j = pixelJ; j < pixelJ + 2 && j < N / 2; ++j) {
                        T aux = matrix[N - j - 1][i];

                        // Fourth Quarter
                        matrix[N - j - 1][i] = matrix[N - i - 1][N - j - 1];
                        // Third Quarter
                        matrix[N - i - 1][N - j - 1] = matrix[j][N - i - 1];
                        // Second Quarter
                        matrix[j][N - i - 1] = matrix[i][j];
                        // First
                        matrix[i][j] = aux;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Integer[][] matrix = new Integer[12][12];

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix.length; ++j) {
                matrix[i][j] = i * 12 + j;
            }
        }

        
        rotate(matrix);
        rotate(matrix);
        rotate(matrix);
        rotate(matrix);

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix.length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}