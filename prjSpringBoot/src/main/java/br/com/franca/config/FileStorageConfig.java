package br.com.franca.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

// quando a aplicação iniciar o spring lê a propriedade file.upload-dir=/projetos/upload e seta no atributo uploadDir as demais propriedades do arquivo app.properties o spring ja faz. 
@ConfigurationProperties(prefix = "file")
public class FileStorageConfig {

	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
}
