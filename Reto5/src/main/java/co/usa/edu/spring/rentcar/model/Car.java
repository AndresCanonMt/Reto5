
package co.usa.edu.spring.rentcar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *   
 * @author Andre
 */

@Entity
@Table(name="car")
public class Car implements Serializable {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(unique = true, nullable = false)
private Integer idCar;

@Column(length = 45, nullable = false)
private String name;
@Column(length = 45, nullable = false)
private String brand;
@Column(nullable = false)
private Integer year;
@Column(length = 250, nullable = false)
private String description;

@ManyToOne
@JoinColumn(name = "idGama")
@JsonIgnoreProperties("cars")
private Gama gama;

@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
@JsonIgnoreProperties({"car","client"})
private List<Message> messages;

@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
@JsonIgnoreProperties("car")
private List<Reservation> reservations;


public Car() {
    super();
}

    public Car(Integer idCar, String name, String brand, Integer year, String description, Gama gama, List<Message> messages, List<Reservation> reservations) {
        this.idCar = idCar;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.gama = gama;
        this.messages = messages;
        this.reservations = reservations;
    }
    
    public Integer getIdCar() {
        return idCar;
    }
    
    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
     * M??todo para recuperar el a??o modelo del veh??culo
     * @return year 
     */
    public Integer getYear() {
        return year;
    }
    /**
     * M??todo para crear el a??o de fabricaci??n o modelo del veh??culo
     * @param year 
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    /**
     * M??todo para recuperar la descripci??n del veh??culo
     * @return description
     */
    public String getDescription() {
        return description;
    }
    /**
     * M??todo para crear una descripci??n del carro 
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * M??todo para recuperar la gama a la que pertenece el carro
     * @return gama 
     */
    public Gama getGama() {
        return gama;
    }
    /**
     * M??todo para crear adicionar la gama a la que pertence el carro
     * @param gama 
     */
    public void setGama(Gama gama) {
        this.gama = gama;
    }
    /**
     * M??todo para recuperar los mensajes del carro
     * @return messages
     */
    public List<Message> getMessages() {
        return messages;
    }
    /**
     * M??todo para crear una lista de mensajes 
     * @param messages  
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    /**
     * M??todo para recuperar una lista de reservaciones
     * @return recupera la lista de reservaciones
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    /**
     * M??todo para crear una lista de reservaciones
     * @param reservations 
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    /**
     * M??todo para convertir a cadena de texto los atributos de la clase 
     * @return devuelve un string de cada uno de los atributos cuando se requiera
     */
    @Override
    public String toString() {
        return "Car{" + "idCar=" + idCar + ", name=" + name + ", brand=" + brand + ", year=" + year + ", description=" + description + ", gama=" + gama + ", messages=" + messages + ", reservations=" + reservations + '}';
    }

   
}
