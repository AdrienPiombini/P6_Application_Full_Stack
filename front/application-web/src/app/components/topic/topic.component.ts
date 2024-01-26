import { Component, OnInit } from '@angular/core';
import { Topic } from 'src/app/models/topic.models';
import { TopicService } from 'src/app/services/topic.service';

@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  styleUrls: ['./topic.component.css'],
})
export class TopicComponent implements OnInit {
  constructor(private readonly topicService: TopicService) {}
  topics!: Topic[];
  ngOnInit(): void {
    this.topicService.getAllTopics().subscribe((topics: Topic[]) => {
      this.topics = topics;
    });
  }

  subscribeToTopic(topic: Topic) {
    this.topicService.subscribeToTopic(topic).subscribe((result) => result);
  }
}
