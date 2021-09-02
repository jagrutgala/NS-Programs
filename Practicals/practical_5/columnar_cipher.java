public class columnar_cipher {
    columnar_cipher() {}

    String encrypt(String text, int row, int col, int[] choice) {
        int count= 0;
        char[][] cont= new char[row][col];
        for(int i= 0; i< row; i++) { // columnar creation
            for(int j= 0; j< col; j++) {
                if(count>= text.length()) {
                    cont[i][j]= ' ';
                } else {
                    cont[i][j]= text.charAt(count);
                }
                count++;
            }
        }

        for(int i= 0; i< col; i++) { // columnar encrption
            int k= choice[i];
            for(int j= 0; j< row; j++) {
                text+= cont[i][k];
            }
        }
        return text;
    }
    
    String decrypt(String text, int row, int col, int[] choice) {
        return text;
    }
    
    public static void main(String[] args) throws IOException, Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        columnar_cipher cc= new columnar_cipher();

        System.out.print("Enter a String: ");
        String text= br.readLine();
        System.out.print("Enter Number of Rows: ");
        int row_num = Integer.parseInt(br.readLine());
        System.out.print("Enter Number of Columns: ");
        int col_num= Integer.parseInt(br.readLine());

        System.out.print("Enter your order of columns: ");
        String[] order= br.readLine().trim().split(" ");
        if(order.length != col_num) {
            throw new Exception("Invalid order of Colmuns given");
        }
        int[] choice= new int[col_num];
        for(int i=0; i<order.length; i++) {
            choice[i]= Integer.parseInt(order[i]);
        }

        String cipher_text=cc.encrypt(text, row_num, col_num, choice);
        System.out.println("Encryption: "+ cipher_text);
        // String detext=cc.decrypt(etext, row_num, col_num, choice);
        // System.out.println("Decryption: "+ cc.encrpt(detext, row_num, col_num, choice));
    }
}
