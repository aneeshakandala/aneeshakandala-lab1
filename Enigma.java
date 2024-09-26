public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));//inner ring
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));//middle ring
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));//outer ring
        
    }


    public String decrypt(String message){        
        //return "";
        //find index of the character on the outer ring, match with index of middle ring
        //find the same character on the middle ring
        //match with character on outer ring, find character that aligns on the innermost ring
        //rotate 
        String decryptedString = "";
        char tempChar1;
        char tempChar2;
        int tempIndex1;
        int tempIndex2;
        
        for (int i = 0; i < message.length(); i++){
            tempIndex1 = this.rotors[2].indexOf(message.charAt(i));
            tempChar1 = this.rotors[1].charAt(tempIndex1);
            tempIndex2 = this.rotors[2].indexOf(tempChar1);
            tempChar2 = this.rotors[0].charAt(tempIndex2);

            decryptedString += tempChar2;

            rotate();
        }
        return decryptedString;
    }


    
    public String encrypt(String message){
        //return "";
        String encryptedString = "";
        char tempChar1;
        char tempChar2;
        int tempIndex1;
        int tempIndex2;
        for (int i = 0; i < message.length(); i++){
            //find the character on the inner ring, note the character aligned with it on outer ring
            //find that character on the middle rotor, then output the one aligned with it on the outer rotor
            //rotate clockwise
            //
            //find index of inner ring, match it to the same index on outer ring
            tempIndex1 = this.rotors[0].indexOf(message.charAt(i));            
            tempChar1 = this.rotors[2].charAt(tempIndex1);
            //charAt to the same character in the middle ring
            tempIndex2 = this.rotors[1].indexOf(tempChar1);
            //find index of middle ring character, match it to the same index on outer ring
            tempChar2 = this.rotors[2].charAt(tempIndex2);
            //add element
            encryptedString += tempChar2;
            //rotate
            rotate(); 
        }
    return encryptedString;
    }
    

    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
