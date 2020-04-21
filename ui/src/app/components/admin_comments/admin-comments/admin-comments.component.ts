import { Component, OnInit } from '@angular/core';
import { CommentService } from 'src/app/comment/service/comment.service';

@Component({
  selector: 'app-admin-comments',
  templateUrl: './admin-comments.component.html',
  styleUrls: ['./admin-comments.component.css'],
})
export class AdminCommentsComponent implements OnInit {
  public comments;
  displayedColumns: string[] = [
    'id',
    'image_id',
    'user_id',
    'comment',
    'createdAt',
    'actions',
  ];

  constructor(private commentService: CommentService) {}

  ngOnInit(): void {
    this.getComments();
  }

  getComments() {
    this.commentService.getComments().subscribe(
      (data) => {
        this.comments = data;
      },
      (err) => console.error(err),
      () => console.log('comments loaded')
    );
  }
}
