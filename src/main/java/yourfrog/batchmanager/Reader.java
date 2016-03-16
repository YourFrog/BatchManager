package yourfrog.batchmanager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 * @author YourFrog
 */
public class Reader implements Runnable
{
    private Process process;
    
    private InputStreamReader input;
    
    private InputStreamReader inputError;
    
    private JTextArea textarea;
    
    public void setProcess(Process process) {
        this.process = process;

        input = new InputStreamReader(process.getInputStream());
        inputError = new InputStreamReader(process.getErrorStream());
    }
    
    public void setTextArea(JTextArea textarea) {
        this.textarea = textarea;
    }
    
    @Override
    public void run() {
        do {
            try {
                readCorrectResponse();
                readErrorResponse();
            } catch(IOException e) {}
        } while( true );
    }
    
    private void readCorrectResponse() throws IOException {
        if( input.ready() == false || inputError.ready() ) {
            return;
        }
        
        String ch = "" + (char) input.read();

        textarea.append(ch);
        textarea.setCaretPosition(textarea.getDocument().getLength());
    }
    
    private void readErrorResponse() throws IOException {
        if( inputError.ready() == false ) {
            return;
        }
        
        String ch = "" + (char) inputError.read();

        textarea.append(ch);
        textarea.setCaretPosition(textarea.getDocument().getLength());
    }
}
