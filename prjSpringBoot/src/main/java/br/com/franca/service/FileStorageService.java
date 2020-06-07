package br.com.franca.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.franca.config.FileStorageConfig;
import br.com.franca.exception.FileStorageException;

@Service
public class FileStorageService {
	private final Path fileStorageLocation;

	@Autowired
	public FileStorageService(FileStorageConfig fileStorageConfig) {
		// obter o diretorio definido no properties 
		this.fileStorageLocation = Paths.get(fileStorageConfig.getUploadDir()).toAbsolutePath().normalize();
		try {
			// tenta criar o diretorio
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception e) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored", e);
		}
	}

	// metodo que armazena o arquivo 
	public String storeFile(MultipartFile file) {
		// pega o nome do arquivo recebido no parâmetro vindo do controller
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			
			// verififca se o nome é válido
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalida path sequence " + fileName);
			}
			// pega o path já definido e acrescenta uma /nomeDoArquivo
			Path targetLocation = this.fileStorageLocation.resolve(fileName);			
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			
			return fileName;
		} catch (Exception e) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
		}
	}
}
