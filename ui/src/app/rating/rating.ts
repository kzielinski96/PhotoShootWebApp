import { User } from '../user/user';
import { Image } from '../image/image';

export class Rating {
  id: number;
  image: Image;
  user: User;
  rating: number;
}
