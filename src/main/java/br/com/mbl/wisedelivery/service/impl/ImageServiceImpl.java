package br.com.mbl.wisedelivery.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ImageServiceImpl {
    
    @Getter @Setter
    private static String diretorioDeUpload;

    public String uploadImagem(MultipartFile bytesDaImagem) {
        StringBuilder buildNomeArquivo = new StringBuilder();
        Path nameArquivoECaminho = Paths.get(diretorioDeUpload, bytesDaImagem.getOriginalFilename());
        try {
            gravaArquivo(nameArquivoECaminho, bytesDaImagem.getBytes());
            buildNomeArquivo.append(nameArquivoECaminho);
        } catch (IOException e) {
            log.error("Erro de IO:" + e.getMessage());
        }
        
        return buildNomeArquivo.toString();
    }


    public static String criarPastaDeUpload(){
        Path diretorioCriado = Paths.get("");
        try {
            diretorioCriado = Files.createDirectory(Paths.get(System.getProperty("user.home") + "/uploads"));
            setDiretorioDeUpload(diretorioCriado.toString());
            log.info("Diretorio criado com sucesso: " + diretorioCriado);
        } catch (IOException e) {
            setDiretorioDeUpload(Paths.get(System.getProperty("user.home") + "/uploads").toString());
            log.error("Erro ao criar o diretório." + e.getMessage());
        }
        
        return diretorioDeUpload;  
    }

    private void gravaArquivo(Path nomeArquivoECaminho,byte[] bytesDaImagem){
        try {
            Files.write(nomeArquivoECaminho, bytesDaImagem, StandardOpenOption.TRUNCATE_EXISTING);
            log.info("Sucesso ao Salvar a imagem!!!");
        } catch (IOException e) {
           try {
             log.error("Erro ao  tentar sobrescrever a imagem. Criando a imagem:" + e.getMessage());
             Files.write(nomeArquivoECaminho,  bytesDaImagem);
           } catch (IOException e1) {
             log.error("Erro ao salvar a imagem:" + e1.getMessage());
           }
        }
    }
}