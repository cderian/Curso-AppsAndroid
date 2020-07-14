# Práctica - Petagram

Aplicación móvil compuesta de dos activities. Se toma como base la aplicación realizada en la Semana 3 de este mismo curso.

__Activity 1:__
Crear un menú que tenga las siguientes dos opciones:
- Contacto. 
    - Llevará a una pantalla con un formulario en el que se solicite nombre, correo y mensaje.
    (Utilizar los Edit Text de Material Design).
    - Agregar un botón "Enviar comentario" el cual tomará la información recopilada y con ayuda de la biblioteca [Java Mail](https://java.net/projects/javamail/pages/Android) envié un mail con el comentario del contacto.
- Acerca de.
    - Llevará a una pantalla con el Bio del desarrollador.

__Fragments:__
- Modularizar el proyecto en Fragments para que estos puedan ser mostrados en un ViewPager.
- Crear un Fragment adicional que muestre el perfil de una mascota. Tendrá su foto de perfil, su nombre y un RecyclerView en donde se mostrarán todas las fotos que ha subido y se acomodarán en forma de Grid.
- Cada ítem deberá contener la foto y la cantidad de raits que se le han dado representado por huesos. Todos los datos son dummy.
- Utilizar la biblioteca [CircularImageView](https://github.com/lopspower/CircularImageView) para generar una imagen redonda como foto de perfil de la mascota.