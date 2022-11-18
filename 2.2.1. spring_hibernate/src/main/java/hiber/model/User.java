package hiber.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne
   @JoinColumn(name = "car")
   @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
private Car car;
   public Car getCar(){
      return car;
   }
   public Car setCar(Car car){
     return this.car=car;

   }


   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Override
   public String toString() {
      return "Id: " +this.getId() + "| Имя: " + this.getFirstName() +
              " | Фамилия: " + this.getLastName() + " | Email: " + this.getEmail() + "| Машина: " +
              this.getCar().getModel() + " | Серия: " + this.getCar().getSeries();
   }

}
