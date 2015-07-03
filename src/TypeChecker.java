public class TypeChecker {
	float kouka = 1;// 自ポケから敵の倍率、逆

	// 抜群なら２倍、今一つは1/2、効果Pokemon.Type.NORMALしは*0
	int i, j; // j_jibun i_teki

	public float typechecke(Pokemon p1, Pokemon p2) {
		Pokemon.Type[] mytype;
		Pokemon.Type[] enetype;
		mytype = new Pokemon.Type[2];
		enetype = new Pokemon.Type[2];
		enetype = p2.getType();//enetypeにp2のタイプを入れる
		mytype = p1.getType();//mytypeにp1のタイプを入れる
		for (i = 0; i <= 1; i++) {//敵のj番目のタイプ(0か1)
			for (j = 0; j <= 1; j++) {

				switch (mytype[j]) {
				case NORMAL:
					if (enetype[i] == Pokemon.Type.ROCK
							|| enetype[i] == Pokemon.Type.STEEL) {
						kouka /= 2;
					}// いまひとつ
					if (enetype[i] == Pokemon.Type.GHOST) {
						kouka *= 0;
					}// 効果Pokemon.Type.NORMALし
					break;

				case FIRE:
					if (enetype[i] == Pokemon.Type.GRASS
							|| enetype[i] == Pokemon.Type.ICE
							|| enetype[i] == Pokemon.Type.BUG) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.FIRE
							|| enetype[i] == Pokemon.Type.WATER
							|| enetype[i] == Pokemon.Type.ROCK
							|| enetype[i] == Pokemon.Type.DRAGON) {
						kouka /= 2;
					}// いまひとつ
					break;

				case WATER:
					if (enetype[i] == Pokemon.Type.FIRE
							|| enetype[i] == Pokemon.Type.GROUND
							|| enetype[i] == Pokemon.Type.ROCK) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.WATER
							|| enetype[i] == Pokemon.Type.GRASS
							|| enetype[i] == Pokemon.Type.DRAGON) {
						kouka /= 2;
					}// いまひとつ
					break;

				case GRASS:
					if (enetype[i] == Pokemon.Type.WATER
							|| enetype[i] == Pokemon.Type.GROUND
							|| enetype[i] == Pokemon.Type.ROCK) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.FIRE
							|| enetype[i] == Pokemon.Type.GRASS
							|| enetype[i] == Pokemon.Type.POISON
							|| enetype[i] == Pokemon.Type.FLYING
							|| enetype[i] == Pokemon.Type.DRAGON
							|| enetype[i] == Pokemon.Type.STEEL) {
						kouka /= 2;
					}// いまひとつ
					break;

				case ELECTRIC:
					if (enetype[i] == Pokemon.Type.WATER
							|| enetype[i] == Pokemon.Type.FLYING) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.GRASS
							|| enetype[i] == Pokemon.Type.ELECTRIC
							|| enetype[i] == Pokemon.Type.DRAGON) {
						kouka /= 2;
					}// いまひとつ
					if (enetype[i] == Pokemon.Type.GROUND) {
						kouka *= 0;
					}// 効果Pokemon.Type.NORMALし
					break;
				case ICE:
					if (enetype[i] == Pokemon.Type.GRASS
							|| enetype[i] == Pokemon.Type.GROUND
							|| enetype[i] == Pokemon.Type.FLYING
							|| enetype[i] == Pokemon.Type.DRAGON) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.FIRE
							|| enetype[i] == Pokemon.Type.WATER
							|| enetype[i] == Pokemon.Type.ICE
							|| enetype[i] == Pokemon.Type.STEEL) {
						kouka /= 2;
					}// いまひとつ
					break;

				case FIGHTING:
					if (enetype[i] == Pokemon.Type.NORMAL
							|| enetype[i] == Pokemon.Type.ICE
							|| enetype[i] == Pokemon.Type.ROCK
							|| enetype[i] == Pokemon.Type.DARK
							|| enetype[i] == Pokemon.Type.STEEL) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.POISON
							|| enetype[i] == Pokemon.Type.FLYING
							|| enetype[i] == Pokemon.Type.PSYCHIC
							|| enetype[i] == Pokemon.Type.BUG
							|| enetype[i] == Pokemon.Type.FAIRY) {
						kouka /= 2;
					}// いまひとつ
					if (enetype[i] == Pokemon.Type.GHOST) {
						kouka *= 0;
					}// 効果Pokemon.Type.NORMALし
					break;

				case POISON:
					if (enetype[i] == Pokemon.Type.GRASS
							|| enetype[i] == Pokemon.Type.FAIRY) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.POISON
							|| enetype[i] == Pokemon.Type.GROUND
							|| enetype[i] == Pokemon.Type.ROCK
							|| enetype[i] == Pokemon.Type.GHOST) {
						kouka /= 2;
					}// いまひとつ
					if (enetype[i] == Pokemon.Type.STEEL) {
						kouka *= 0;
					}// 効果Pokemon.Type.NORMALし
					break;

				case GROUND:
					if (enetype[i] == Pokemon.Type.FIRE
							|| enetype[i] == Pokemon.Type.ELECTRIC
							|| enetype[i] == Pokemon.Type.POISON
							|| enetype[i] == Pokemon.Type.ROCK
							|| enetype[i] == Pokemon.Type.STEEL) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.GRASS
							|| enetype[i] == Pokemon.Type.BUG) {
						kouka /= 2;
					}// いまひとつ
					if (enetype[i] == Pokemon.Type.FLYING) {
						kouka *= 0;
					}// 効果Pokemon.Type.NORMALし
					break;

				case FLYING:
					if (enetype[i] == Pokemon.Type.GRASS
							|| enetype[i] == Pokemon.Type.FIGHTING
							|| enetype[i] == Pokemon.Type.BUG) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.ELECTRIC
							|| enetype[i] == Pokemon.Type.ROCK
							|| enetype[i] == Pokemon.Type.STEEL) {
						kouka /= 2;
					}// いまひとつ
					break;

				case PSYCHIC:
					if (enetype[i] == Pokemon.Type.FIGHTING
							|| enetype[i] == Pokemon.Type.POISON) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.PSYCHIC
							|| enetype[i] == Pokemon.Type.STEEL) {
						kouka /= 2;
					}// いまひとつ
					if (enetype[i] == Pokemon.Type.DARK) {
						kouka *= 0;
					}// 効果Pokemon.Type.NORMALし
					break;

				case BUG:
					if (enetype[i] == Pokemon.Type.GRASS
							|| enetype[i] == Pokemon.Type.PSYCHIC
							|| enetype[i] == Pokemon.Type.DARK) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.FIRE
							|| enetype[i] == Pokemon.Type.FIGHTING
							|| enetype[i] == Pokemon.Type.POISON
							|| enetype[i] == Pokemon.Type.FLYING
							|| enetype[i] == Pokemon.Type.GHOST
							|| enetype[i] == Pokemon.Type.STEEL
							|| enetype[i] == Pokemon.Type.FAIRY) {
						kouka /= 2;
					}// いまひとつ
					break;

				case ROCK:
					if (enetype[i] == Pokemon.Type.FIRE
							|| enetype[i] == Pokemon.Type.ICE
							|| enetype[i] == Pokemon.Type.FLYING
							|| enetype[i] == Pokemon.Type.BUG) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.FIGHTING
							|| enetype[i] == Pokemon.Type.GROUND
							|| enetype[i] == Pokemon.Type.STEEL) {
						kouka /= 2;
					}// いまひとつ
					break;

				case GHOST:
					if (enetype[i] == Pokemon.Type.PSYCHIC
							|| enetype[i] == Pokemon.Type.GHOST) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.DARK) {
						kouka /= 2;
					}// いまひとつ
					if (enetype[i] == Pokemon.Type.NORMAL) {
						kouka *= 0;
					}// 効果Pokemon.Type.NORMALし
					break;

				case DRAGON:
					if (enetype[i] == Pokemon.Type.DRAGON) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.STEEL) {
						kouka /= 2;
					}// いまひとつ
					if (enetype[i] == Pokemon.Type.FAIRY) {
						kouka *= 0;
					}// 効果Pokemon.Type.NORMALし
					break;

				case DARK:
					if (enetype[i] == Pokemon.Type.PSYCHIC
							|| enetype[i] == Pokemon.Type.GHOST) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.FIGHTING
							|| enetype[i] == Pokemon.Type.DARK
							|| enetype[i] == Pokemon.Type.FAIRY) {
						kouka /= 2;
					}// いまひとつ
					break;

				case STEEL:
					if (enetype[i] == Pokemon.Type.ICE
							|| enetype[i] == Pokemon.Type.ROCK
							|| enetype[i] == Pokemon.Type.FAIRY) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.FIRE
							|| enetype[i] == Pokemon.Type.WATER
							|| enetype[i] == Pokemon.Type.ELECTRIC
							|| enetype[i] == Pokemon.Type.STEEL) {
						kouka /= 2;
					}// いまひとつ
					break;

				case FAIRY:
					if (enetype[i] == Pokemon.Type.FIGHTING
							|| enetype[i] == Pokemon.Type.DRAGON
							|| enetype[i] == Pokemon.Type.DARK) {
						kouka *= 2;
					}// 抜群
					if (enetype[i] == Pokemon.Type.FIRE
							|| enetype[i] == Pokemon.Type.POISON
							|| enetype[i] == Pokemon.Type.STEEL) {
						kouka /= 2;
					}// いまひとつ
					break;
				case NONE:
					break;// タイプナシなら何もせずに終わる
				}

			}
		}

		return kouka;// 計算結果の
	}
}
