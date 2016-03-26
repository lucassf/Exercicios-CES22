package ces22;

public class InputHandler {

    private String input;
    private boolean signed;
    
    public InputHandler() {
        ResetInput();
    }

    public void setInput(char a){
        if (a=='u'){
            if (input.length()>1)input = input.substring(0, input.length()-1);
            else input="0";
        }else if (a=='-'){
            signed = !signed;
        }
        else if (input.length()==1&&input.charAt(0)=='0'&&a!='.'){
            input=String.valueOf(a);
        }
        else {
            try{
                VerifyInput(input + a);
                input += a;
            }catch(WrongInputException e){}
        }if (input.equals("0")||input.equals("0."))signed=false;
    }

    public String getInput() {
        return (signed?"-":"")+input;
    }
    
    public void ResetInput(){
        input="0";
        signed=false;
    }
    
    private void VerifyInput(String input) throws WrongInputException {
        boolean verify = true;
        if (input.length() > 9) {
            verify = false;
        }
        try {
            double u = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            verify = false;
        }
        if (!verify) {
            throw new WrongInputException("");
        }
    }
}