package com.example.interfazusuario
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    //private lateinit var sexo: String // para inicializar después
    private var sexo = "Masculino" // siempre poner variables privada porque es un atibuto de la clase
    private var hobbies= ""
    private var lugar= ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btGuardar.setOnClickListener {
            var nombre = etNombre.text.toString()
            var contraseña = etContraseña.text.toString()
            var confircontra = etContaConfirm.text.toString()
            var correo = etCorreo.text.toString()
            var cedula = etCedula.text.toString()
            var fecha = tvMuestafecha.text.toString()

            if (nombre == "") {
                Toast.makeText(this, "Campo de nombre vacío", Toast.LENGTH_LONG).show();
            } else {

                if (contraseña == "") {
                    Toast.makeText(this, "Campo de contraseña vacío", Toast.LENGTH_LONG).show();
                } else {

                    if (confircontra == "") {
                        Toast.makeText(this, "Campo de confirmación de contraseña vacío", Toast.LENGTH_LONG).show();
                    } else {

                        if (contraseña != confircontra) {
                            Toast.makeText(
                                this,
                                "Los campos de contraseña con coinciden, por favor ingreselos de nuevo",
                                Toast.LENGTH_LONG
                            ).show();
                            etContraseña.setText("")
                            etContaConfirm.setText("")
                        } else {

                            if (correo == "") {
                                Toast.makeText(this, "Campo de correo vacío", Toast.LENGTH_LONG).show();
                            } else {

                                if (cedula == "") {
                                    Toast.makeText(this, "Campo de número de documento vacío", Toast.LENGTH_LONG)
                                        .show();
                                } else {

                                    if (fecha == "") {
                                        Toast.makeText(
                                            this, "No ha seleccionado su fecha de nacimiento, por favor hágalo",
                                            Toast.LENGTH_LONG
                                        ).show();
                                    } else {
                                        if (lugar == "") {
                                            Toast.makeText(
                                                this, "No ha seleccionado lugar de nacimiento, por favor hágalo",
                                                Toast.LENGTH_LONG
                                            ).show();
                                        } else {
                                            if (hobbies == "") {
                                                Toast.makeText(
                                                    this, "No ha seleccionado ningun Hobbie, por favor hágalo",
                                                    Toast.LENGTH_LONG
                                                ).show();
                                            } else {

                                                var respuesta =
                                                    nombre + "\n" + contraseña + "\n" + correo + "\n" + cedula + "\n" + fecha + "\n" + lugar + "\n" +sexo + "\n" + hobbies
                                                tvResultado.text = respuesta
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        btFecha.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val calendario = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->

                tvMuestafecha.text=("" + day + "/" + (month + 1) + "/" + year)

            }, year, month, day)

            calendario.show()
        }

        val paises = arrayOf("","Colombia","EEUU", "Japón", "Brasil")

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, paises
        )

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        spLugar.adapter = adapter

        spLugar.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Display the selected item text on text view
                tvMestralugar.text = "${parent.getItemAtPosition(position).toString()}"
                lugar = tvMestralugar.text.toString()
            }
        }


    }

    fun onRadioButtonClicked (view: View){

        if(view is RadioButton){
            when (view.id){
                R.id.rbMasculino ->
                    if(view.isChecked){
                        sexo = "Masculino"
                    }
                R.id.rbFemenino ->
                    if(view.isChecked){
                        sexo = "Femenino"
                }
            }
        }

    }

    fun onCheckboxClicked (view: View){

        if(view is CheckBox) {
            when (view.id) {
                R.id.cbCine ->
                    if (view.isChecked) {
                        hobbies = hobbies + "Cine "
                    }
                R.id.cbLeer ->
                    if (view.isChecked) {
                        hobbies = hobbies + "Leer "
                    }
                R.id.cbCorrer ->
                    if (view.isChecked) {
                        hobbies = hobbies + "Correr "
                    }
                R.id.cbNadar ->
                    if (view.isChecked) {
                        hobbies = hobbies + "Nadar "
                    }
            }

        }
    }

}