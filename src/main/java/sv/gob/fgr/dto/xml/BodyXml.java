package sv.gob.fgr.dto.xml;

import jakarta.xml.bind.annotation.XmlElement;

public class BodyXml {

    @XmlElement(name = "FullCountryInfoResponse")
    public FullCountryInfoResponseXml fullCountryInfoResponseXml;

}
