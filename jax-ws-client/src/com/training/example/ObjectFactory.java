
package com.training.example;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.training.example package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Weather_QNAME = new QName("http://ifaces.training.com/", "weather");
    private final static QName _WeatherWrapper_QNAME = new QName("http://ifaces.training.com/", "weatherWrapper");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.training.example
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WeatherWrapper }
     * 
     */
    public WeatherWrapper createWeatherWrapper() {
        return new WeatherWrapper();
    }

    /**
     * Create an instance of {@link Weather }
     * 
     */
    public Weather createWeather() {
        return new Weather();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Weather }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ifaces.training.com/", name = "weather")
    public JAXBElement<Weather> createWeather(Weather value) {
        return new JAXBElement<Weather>(_Weather_QNAME, Weather.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeatherWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ifaces.training.com/", name = "weatherWrapper")
    public JAXBElement<WeatherWrapper> createWeatherWrapper(WeatherWrapper value) {
        return new JAXBElement<WeatherWrapper>(_WeatherWrapper_QNAME, WeatherWrapper.class, null, value);
    }

}
