import { TopicTitle } from 'src/app/interfaces/topic.interface';

export class Post {
  constructor(
    public id: Number,
    public title: string,
    public content: string,
    public topic: TopicTitle,
    public user: string
  ) {}
}
