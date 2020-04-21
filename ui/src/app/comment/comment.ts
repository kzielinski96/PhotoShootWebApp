import { User } from '../user/user';
import { Image } from '../image/image';

export class Comment {
  id: number;
  image: Image;
  user: User;
  comment: string;
  createdAt: string;
}
