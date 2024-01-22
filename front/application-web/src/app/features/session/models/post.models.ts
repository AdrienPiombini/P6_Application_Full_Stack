import { TopicTitle } from 'src/app/interfaces/topic.interface';

export class Post {
  constructor(
    public id: Number,
    public title: string,
    public content: string,
    public topic: TopicTitle,
    public created_at: string,
    public user: string,
    public commentaries: Commentary[]
  ) {}
}
export type Commentary = {
  message: string;
  user: string;
  created_at: Date;
};
