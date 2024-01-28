import { TopicTitle } from 'src/app/interfaces/topic.interface';

export interface PostRequest {
  title: string;
  content: string;
  topic: TopicTitle;
}
