package iherrera.cursokotlin.com.Section_01.Models

import android.os.Parcel
import android.os.Parcelable

// Parcel es un contenedor para un mensaje
// Puede ser usado para mandar un objeto serializado a traves de internet
// Mejor rendimiento que Serializer
data class Student(
    var name: String?,
    var lastName: String?,
    var age: Int,
    var isDeveloper: Boolean = true
) : Parcelable {

    // Leer en el mismo orden que declaramos las propiedades
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    // Tenemos que escribir los valores en el mismo orden en el que leemos en el constructor Secundario
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if (isDeveloper) 1 else 0)
    }

    // Describe el tipo de contenido del objeto Parcelable
    // 0 simepre se usa, el otro valor es 1 o
    // CONTENTS_FILE_DESCRIPTION, para tipos de objetos que implementan un File Descriptor
    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {

        // Esto creara el objeto desde el parcel llamando al constructor SECUNDARIO
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        // Esto ayudara a serializar arrays de objetos del mismo tipo que esta clase (Student)
        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}