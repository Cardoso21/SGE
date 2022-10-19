package br.com.sge.servico;


import br.com.sge.dominio.Evento_;
import br.com.sge.servico.Config.ApplicationProperties;
import br.com.sge.servico.DTO.EmailDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;


@Service
@RequiredArgsConstructor
@Transactional
public class EmailServico {

    private final JavaMailSender javaSenderEmail;
    private final ApplicationProperties applicationProperties;

    @SneakyThrows
    public void sendEmail(EmailDTO emailDTO){

//        List<String> listaDestinatarios = new ArrayList<>();

        MimeMessage mimeMessage = javaSenderEmail.createMimeMessage();
        MimeMessageHelper mime = new MimeMessageHelper(mimeMessage);

        mime.setTo(emailDTO.getDestinatario());
        mime.setFrom(applicationProperties.getEnderecoRemetente());
        mime.setSubject(emailDTO.getAssunto());

        for(String s : emailDTO.getCopias()){
            mime.addCc(s);
        }

        mime.setText("Patrocinador: " + Evento_.usuario );
        javaSenderEmail.send(mimeMessage);
    }
}
