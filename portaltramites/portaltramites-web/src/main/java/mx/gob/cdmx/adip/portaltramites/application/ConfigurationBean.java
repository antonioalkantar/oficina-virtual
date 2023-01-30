package mx.gob.cdmx.adip.portaltramites.application;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;

@Named("configurationBean")
@ApplicationScoped
public class ConfigurationBean implements Serializable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationBean.class);
	private static final long serialVersionUID = 9087551321296717271L;

	/**
	 * Método que determina si el HTML Meta robots debe tener el valor "all" (para que sea indexado por los buscadores)
	 * o que sea "noindex" para que no sea indexado, por ejemplo si el sistema está desplegado en un ambiente DEV
	 * @return
	 */
	public String parametroMetaRobots() {
		return Environment.getAppProfile().compareTo("prod") == 0 ? "all" : "noindex";
	}
}
