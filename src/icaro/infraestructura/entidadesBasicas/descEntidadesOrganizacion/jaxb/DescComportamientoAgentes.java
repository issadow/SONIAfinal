//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2012.07.04 at 04:19:28 PM CEST
//

package icaro.infraestructura.entidadesBasicas.descEntidadesOrganizacion.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DescComportamientoAgentes complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="DescComportamientoAgentes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DescComportamientoGestores" type="{urn:icaro:aplicaciones:descripcionOrganizaciones}DescComportamientoGestores"/>
 *         &lt;element name="DescComportamientoAgentesAplicacion" type="{urn:icaro:aplicaciones:descripcionOrganizaciones}DescComportamientoAgentesAplicacion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DescComportamientoAgentes", propOrder = {
		"descComportamientoGestores", "descComportamientoAgentesAplicacion" })
public class DescComportamientoAgentes {

	@XmlElement(name = "DescComportamientoGestores", required = true)
	protected DescComportamientoGestores descComportamientoGestores;
	@XmlElement(name = "DescComportamientoAgentesAplicacion", required = true)
	protected DescComportamientoAgentesAplicacion descComportamientoAgentesAplicacion;

	/**
	 * Gets the value of the descComportamientoGestores property.
	 *
	 * @return possible object is {@link DescComportamientoGestores }
	 *
	 */
	public DescComportamientoGestores getDescComportamientoGestores() {
		return descComportamientoGestores;
	}

	/**
	 * Sets the value of the descComportamientoGestores property.
	 *
	 * @param value
	 *            allowed object is {@link DescComportamientoGestores }
	 *
	 */
	public void setDescComportamientoGestores(DescComportamientoGestores value) {
		this.descComportamientoGestores = value;
	}

	/**
	 * Gets the value of the descComportamientoAgentesAplicacion property.
	 *
	 * @return possible object is {@link DescComportamientoAgentesAplicacion }
	 *
	 */
	public DescComportamientoAgentesAplicacion getDescComportamientoAgentesAplicacion() {
		return descComportamientoAgentesAplicacion;
	}

	/**
	 * Sets the value of the descComportamientoAgentesAplicacion property.
	 *
	 * @param value
	 *            allowed object is {@link DescComportamientoAgentesAplicacion }
	 *
	 */
	public void setDescComportamientoAgentesAplicacion(
			DescComportamientoAgentesAplicacion value) {
		this.descComportamientoAgentesAplicacion = value;
	}

}
