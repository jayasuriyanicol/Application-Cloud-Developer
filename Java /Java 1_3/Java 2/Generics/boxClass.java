/*In this case we use as first the Object as form of the attribute elemento, but when we want to get the element, the object element is too generics.
    
  On the other hand, we can assume that the class Box chave the generics, so we can after when get the element specify the type of the element */



//Defining the Box don't using the generics form, but only the OBJ
public class Box {


        private Object elemento;

        public Box(Object ob){

            this.elemento = ob;

           }


        public Object getElemento(){

                this.elemento = void setElemento(Object);

           }


   }



/*  

Defining, the Generics mode, that is the best solution possibile. ALso the JVM do not check the Generics

Generics Mode:

public class Box <E> {


        private E elemento;

        public Box(E ob){

            this.elemento = ob;

           }


        public E getElemento(){

                this.elemento = void setElemento(E);

           }


   }





*/





