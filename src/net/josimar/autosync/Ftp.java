package net.josimar.autosync;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import io.github.cdimascio.dotenv.Dotenv;

public class Ftp {

	private String localFile;
	private String remoteFile;
	
	public Ftp(String localFile, String remoteFile) {
		super();
		this.localFile = localFile;
		this.remoteFile = remoteFile;
		
			Dotenv dotenv = Dotenv.load();
	        String server = dotenv.get("host")  ;
	        int port = Integer.valueOf(dotenv.get("port"));
	        String user = dotenv.get("user");
	        String pass = dotenv.get("pass");
	 
	        FTPClient ftpClient = new FTPClient();
	        
	        try {
	        	 
	            ftpClient.connect(server, port);
	            ftpClient.login(user, pass);
	            ftpClient.enterLocalPassiveMode();
	 
	            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	 
	            // APPROACH #1: uploads first file using an InputStream
	            File firstLocalFile = new File(this.localFile);
	 
	            String firstRemoteFile = this.remoteFile;
	            InputStream inputStream = new FileInputStream(firstLocalFile);
	 
	            System.out.println("Local:"+localFile);
	            System.out.println("Remoto:"+remoteFile);
	            
	            System.out.println("Start uploading first file");
	            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
	            inputStream.close();
	            if (done) {
	                System.out.println("The first file is uploaded successfully.");
	            }
	        } catch (IOException ex) {
	            System.out.println("Error: " + ex.getMessage());
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (ftpClient.isConnected()) {
	                    ftpClient.logout();
	                    ftpClient.disconnect();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	}
	
	
}
