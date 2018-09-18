/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author Ismael
 */
@Named(value = "fileUploadController")
@ViewScoped
public class FileUploadController implements Serializable {

    private Part filePart;

    /**
     * Creates a new instance of FileUploadController
     */
    public FileUploadController() {
    }

    @PostConstruct
    public void init() {

    }

    public Part getFilePart() {
        return filePart;
    }

    public void setFilePart(Part filePart) {
        this.filePart = filePart;
    }

    public void uploadFiles() {
        try {
            List<Part> pFiles = getPartsFiles();
            for (Part filePart : pFiles) {
                System.out.println("Estos son los datos del archivo:");
                System.out.println("Name 1: " + filePart.getName());
                System.out.println("Name 2: " + filePart.getSubmittedFileName());
                System.out.println("Type: " + filePart.getContentType());
                System.out.println("Size: " + filePart.getSize());
                saveFile(filePart);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            ex.printStackTrace();
            //Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String uploadFile(Part filePart) {
        String o = null;
        try {
            System.out.println("Estos son los datos del archivo:");
            System.out.println("Name 1: " + filePart.getName());
            System.out.println("Name 2: " + filePart.getSubmittedFileName());
            System.out.println("Type: " + filePart.getContentType());
            System.out.println("Size: " + filePart.getSize());
            o = saveFile(filePart);
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);

        }
        return o;
    }

    private List<Part> getPartsFiles() throws IOException, ServletException {
        List<Part> partsFiles = new ArrayList<>();
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest rq = (HttpServletRequest) ec.getRequest();
        Collection<Part> parts = rq.getParts();
        for (Part part : parts) {
            if (part.getSize() > 0 && part.getSubmittedFileName() != null) {
                partsFiles.add(part);
            }
        }
        return partsFiles;
    }

    private String saveFile(Part p) throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        String path = ec.getRealPath("") + "/productos/";
        File dir = new File(path);
        dir.mkdirs();
        File file = new File(dir, getNameFile(p.getSubmittedFileName()));
        file.createNewFile();

        FileOutputStream outputStream = new FileOutputStream(file);
        InputStream inputStream = p.getInputStream();

        byte[] buffer = new byte[1024];
        int length;

        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.close();
        inputStream.close();
        System.out.println(getNameFile(p.getSubmittedFileName()));
        return getNameFile(p.getSubmittedFileName());
    }

    private String getNameFile(String path) {
        String[] datos = path.split("\\\\");
        return datos[datos.length - 1];
    }

    private String getExtention(String path) {
        String[] datos = path.split("\\.");
        return datos[datos.length - 1];
    }

    private String getOnlyNameFile(String path) {
        String[] datos = path.split("\\.");
        String[] datos2 = datos[0].split("\\\\");
        return datos2[datos2.length - 1];
        /*
        String[] datos = path.split("\\\\");
        String[] datos2 = datos[datos.length - 1].split("\\.");
        return datos2[0];
         */
    }

}
