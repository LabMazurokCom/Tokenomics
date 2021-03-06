/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author igor
 */
public class Keys {
	private final KeyPairGenerator keyGen;
	private KeyPair pair;
	private PrivateKey privateKey;
	private PublicKey publicKey;

	public Keys(int keylength) throws NoSuchAlgorithmException, NoSuchProviderException {
		this.keyGen = KeyPairGenerator.getInstance("RSA");
		this.keyGen.initialize(keylength);
	}

	public void createKeys() {
		this.pair = this.keyGen.generateKeyPair();
		this.privateKey = pair.getPrivate();
		this.publicKey = pair.getPublic();
	}

	public PrivateKey getPrivateKey() {
		return this.privateKey;
	}

	public PublicKey getPublicKey() {
		return this.publicKey;
	}

	public void writeToFile(String path, byte[] key) throws IOException {
		File f = new File(path);
		f.getParentFile().mkdirs();

            try (FileOutputStream fos = new FileOutputStream(f)) {
                fos.write(key);
                fos.flush();
            }
	}

	public static void main(String[] args) {
		Keys gk;
		try {
			gk = new Keys(1024);
			gk.createKeys();
			gk.writeToFile("KeyPair/publicKey", gk.getPublicKey().getEncoded());
			gk.writeToFile("KeyPair/privateKey", gk.getPrivateKey().getEncoded());
		} catch (NoSuchAlgorithmException | NoSuchProviderException | IOException e) {
			System.err.println(e.getMessage());
		}

	}

}