import { Topic } from './Topic';

export interface PostRequest {
  title: string;
  content: string;
  topic: Topic;
}
