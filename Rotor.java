public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        String rotor = this.rotorValues;

        rotor = rotorValues.charAt(rotorValues.length()-1) + rotor.substring(0, rotor.length()-1);

        this.rotorValues = rotor;

        if (rotor.charAt(0) == startChar){
            return true;
        }
        return false;
    }
    

    public int indexOf(char c){
        return this.rotorValues.indexOf(c);
    }

    public char charAt(int idx){
        return this.rotorValues.charAt(idx);
    }
}
    
