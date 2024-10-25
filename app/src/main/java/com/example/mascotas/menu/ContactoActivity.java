package com.example.mascotas.menu;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mascotas.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;

public class ContactoActivity extends AppCompatActivity {

    private EditText etNombre, etCorreo, etMensaje;
    private Button btnEnviar;
    String sCorreo, sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etMensaje = findViewById(R.id.etMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);

        sCorreo = "correo@gmail.com";
        sPassword = "contraseña";

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString().trim();
                String correo = etCorreo.getText().toString().trim();
                String mensaje = etMensaje.getText().toString().trim();

                if (nombre.isEmpty() || correo.isEmpty() || mensaje.isEmpty()) {
                    Toast.makeText(ContactoActivity.this, "Llena todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    sendEmail(nombre, correo, mensaje);
                }
            }
        });
    }

    private void sendEmail(String nombre, String correo, String mensaje) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sCorreo, sPassword);
            }
        });

        try {
            Message messageObj = new MimeMessage(session);
            messageObj.setFrom(new InternetAddress(sCorreo));
            messageObj.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("destinatario@gmail.com"));
            messageObj.setSubject("Nuevo comentario de: " + nombre);
            messageObj.setText("Correo: " + correo + "\nMensaje: " + mensaje);
            new SendMail().execute(messageObj);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private class SendMail extends AsyncTask<Message, String, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(ContactoActivity.this,
                    "Por favor espera", "Enviando correo...", true, false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return "Success";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "Error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            if (result.equals("Success")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ContactoActivity.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color = '#509324'>Éxito</font>"));
                builder.setMessage("Correo enviado con éxito.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        etNombre.setText("");
                        etCorreo.setText("");
                        etMensaje.setText("");
                    }
                });
                builder.show();
            } else {
                Toast.makeText(getApplicationContext(), "Algo salió mal", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
