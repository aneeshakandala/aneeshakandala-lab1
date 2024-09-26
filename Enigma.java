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

        String decryptedString = "";
        int outerIndex1;
        int outerIndex2;
        char middleChar;
        char finalChar;
        
        for (int i = 0; i < message.length(); i++){
            //find index of the character on the outer ring
            outerIndex1 = this.rotors[2].indexOf(message.charAt(i));
            //find the same character on the middle ring
            middleChar = this.rotors[1].charAt(outerIndex1);
            //match with character on outer ring
            outerIndex2 = this.rotors[2].indexOf(middleChar);
            //find character that aligns on the innermost ring
            finalChar = this.rotors[0].charAt(outerIndex2);
            //add element
            decryptedString += finalChar;
            //rotate
            rotate();
        }
        return decryptedString;
    }


    
    public String encrypt(String message){

        String encryptedString = "";
        char outerChar;
        char finalChar;
        int innerIndex;
        int middleIndex;

        for (int i = 0; i < message.length(); i++){
            //find the character on the inner ring, note the character aligned with it on outer ring
            //find that character on the middle rotor, then output the one aligned with it on the outer rotor
            //rotate clockwise

            //find index of inner ring, match it to the character with the same index on outer ring
            innerIndex= this.rotors[0].indexOf(message.charAt(i));            
            outerChar = this.rotors[2].charAt(innerIndex);
            //find the same character in the middle ring
            middleIndex = this.rotors[1].indexOf(outerChar);
            //find index of middle ring character, match it to the char with the same index on outer ring
            finalChar = this.rotors[2].charAt(middleIndex);
            //add element
            encryptedString += finalChar;
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
