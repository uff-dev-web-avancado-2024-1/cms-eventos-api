package com.example.cmseventosapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmseventosapi.Model.Message;
import com.example.cmseventosapi.Repositories.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository repository;
 
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private UserRepository userRepository;

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

    @Scheduled(fixedRate = 3600000) // Verifica a cada hora
    public void sendEventReminderEmails() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneHourLater = now.plusHours(1);
        List<User> users = userRepository.findAll();

        for (User user : users) {
            for (Activity activity : user.getFavoriteActivities()) {
                if (activity.getStartTime().isAfter(now) && activity.getStartTime().isBefore(oneHourLater)) {
                    sendEmail(user.getEmail(), "Lembrete de atividades favoritadas",
                        "Prezado, " + user.getName() + ",\n\n" +
                                "Este é um lembrete para a seguinte atividade que iniciará em breve::\n\n" +
                                "Atividade: " + activity.getName() + "\n" +
                                "Horário: " + activity.getStartTime() + "\n" +
                                "Local: " + activity.getLocation() + "\n\n" +
                                "Atenciosamente,\nEquipe de evento");
                }
            }
        }
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
    
}
