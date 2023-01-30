package mx.gob.cdmx.adip.portaltramites.util;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.StreamedContent;

@Named("streamedView")
@SessionScoped
public class StreamedView implements Serializable{

	private static final long serialVersionUID = -1182282393300020284L;
	
	private StreamedContent File;
	
    public StreamedView() {
    }

    public void ShowStreamed(StreamedContent file) {
        this.File = file;
    }

    public StreamedContent getFile() {
        return File;
    }

    public void setFile(StreamedContent File) {
        this.File = File;
    }

}
