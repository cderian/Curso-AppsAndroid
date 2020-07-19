package com.cderian.contactos.database;

public final class ConstanteBDD {

    public static final String DATABASE_NAME = "Contactos";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLA_CONTACTO           = "contactos";
    public static final String TABLA_CONTACTO_ID        = "id";
    public static final String TABLA_CONTACTO_NOMBRE    = "nombre";
    public static final String TABLA_CONTACTO_TELEFONO  = "telefono";
    public static final String TABLA_CONTACTO_EMAIL     = "email";
    public static final String TABLA_CONTACTO_FOTO      = "foto";

    public static final String TABLA_LIKES              = "contacto_likes";
    public static final String TABLA_LIKES_ID           = "id";
    public static final String TABLA_LIKES_ID_CONTACTO  = "id_contacto";
    public static final String TABLA_LIKES_NUMERO       = "numero_likes";
}
