package com.example.cmseventosapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.cmseventosapi.Model.Activity;
import com.example.cmseventosapi.Model.Message;
import com.example.cmseventosapi.Model.User;
import com.example.cmseventosapi.Repositories.MessageRepository;
import com.example.cmseventosapi.Repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.time.ZoneId;

@Service
public class MessageService {
    
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository repository;

    public Message CreateMessage(Message message) {
        return this.repository.save(message);
    }

    public Message UpdateMessage(Message message, Long id) {
        Message messageToUpdate = this.repository.findById(id).get();
        messageToUpdate.setContent(message.getContent());
        messageToUpdate.setSender(message.getSender());
        messageToUpdate.setReceiver(message.getReceiver());
        return this.repository.save(message);
    }

    public Message GetMessage(Long id) {
        return this.repository.findById(id).get();
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    @Scheduled(cron = "0 0 * * * *") // Executa a cada hora
    public void sendActivityReminders() {
        List<User> users = userRepository.findAll();
        LocalDateTime now = LocalDateTime.now();
        Date nowDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

        for (User user : users) {
            StringBuilder emailBody = new StringBuilder();
            List<Activity> favoriteActivities = user.getFavoriteActivities();

            for (Activity activity : favoriteActivities) {
                Date activityDate = activity.getDate();
                Date activityStartTime = activity.getStartTime();

                if (isWithinNextHour(nowDate, activityDate, activityStartTime)) {
                    emailBody.append("Atividade: ").append(activity.getName()).append("\n")
                             .append("Descrição: ").append(activity.getDescription()).append("\n")
                             .append("Local: ").append(activity.getSpace().getName()).append("\n")
                             .append("Horário: ").append(activity.getStartTime()).append(" - ").append(activity.getEndTime()).append("\n\n");
                }
            }

            if (emailBody.length() > 0) {
                sendEmail(user.getEmail(), "Lembrete de Atividades do Evento", emailBody.toString());
            }
        }
    }

    private boolean isWithinNextHour(Date now, Date activityDate, Date activityStartTime) {
        LocalDateTime activityDateTime = LocalDateTime.ofInstant(activityStartTime.toInstant(), ZoneId.systemDefault());
        LocalDateTime nowDateTime = LocalDateTime.ofInstant(now.toInstant(), ZoneId.systemDefault());

        return nowDateTime.toLocalDate().equals(activityDateTime.toLocalDate()) &&
               activityDateTime.toLocalTime().isAfter(nowDateTime.toLocalTime()) &&
               activityDateTime.toLocalTime().isBefore(nowDateTime.plusHours(1).toLocalTime());
    }
}
