package fr.sebaseg.datalayer.service;

import fr.sebaseg.datalayer.model.Comment;
import fr.sebaseg.datalayer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public Iterable<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Integer id) {
        return commentRepository.findById(id);
    }
}
