public class TypeChecker {
	EffectRelation.Effect effect;

	// 抜群なら２倍、今一つは1/2、効果Pokemon.Type.NORMALしは*0

	public EffectRelation typecheck(Pokemon p1, Pokemon p2) {

		EffectRelation ef = new EffectRelation(p1, p2, null);

		float kouka[] = { 1, 1 };// 倍率
		float highkouka;
		int i, j; // j_teki i_jibun
		Pokemon.Type[] mytype;
		Pokemon.Type[] enetype;
		mytype = new Pokemon.Type[2];
		enetype = new Pokemon.Type[2];
		enetype = p2.getType();// enetypeにp2のタイプを入れる
		mytype = p1.getType();// mytypeにp1のタイプを入れる

		if (mytype[0] == Pokemon.Type.NONE && mytype[1] == Pokemon.Type.NONE) {
			
		} else {

			for (i = 0; i <= 1; i++) {// 敵のj番目のタイプ(0か1)
				for (j = 0; j <= 1; j++) {

					switch (mytype[i]) {
					case NORMAL:
						if (enetype[j] == Pokemon.Type.ROCK
								|| enetype[j] == Pokemon.Type.STEEL) {
							kouka[i] /= 2;
						}// いまひとつ
						if (enetype[j] == Pokemon.Type.GHOST) {
							kouka[i] *= 0;
						}// 効果Pokemon.Type.NORMALし
						break;

					case FIRE:
						if (enetype[j] == Pokemon.Type.GRASS
								|| enetype[j] == Pokemon.Type.ICE
								|| enetype[j] == Pokemon.Type.BUG) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.FIRE
								|| enetype[j] == Pokemon.Type.WATER
								|| enetype[j] == Pokemon.Type.ROCK
								|| enetype[j] == Pokemon.Type.DRAGON) {
							kouka[i] /= 2;
						}// いまひとつ
						break;

					case WATER:
						if (enetype[j] == Pokemon.Type.FIRE
								|| enetype[j] == Pokemon.Type.GROUND
								|| enetype[j] == Pokemon.Type.ROCK) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.WATER
								|| enetype[j] == Pokemon.Type.GRASS
								|| enetype[j] == Pokemon.Type.DRAGON) {
							kouka[i] /= 2;
						}// いまひとつ
						break;

					case GRASS:
						if (enetype[j] == Pokemon.Type.WATER
								|| enetype[j] == Pokemon.Type.GROUND
								|| enetype[j] == Pokemon.Type.ROCK) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.FIRE
								|| enetype[j] == Pokemon.Type.GRASS
								|| enetype[j] == Pokemon.Type.POISON
								|| enetype[j] == Pokemon.Type.FLYING
								|| enetype[j] == Pokemon.Type.DRAGON
								|| enetype[j] == Pokemon.Type.STEEL) {
							kouka[i] /= 2;
						}// いまひとつ
						break;

					case ELECTRIC:
						if (enetype[j] == Pokemon.Type.WATER
								|| enetype[j] == Pokemon.Type.FLYING) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.GRASS
								|| enetype[j] == Pokemon.Type.ELECTRIC
								|| enetype[j] == Pokemon.Type.DRAGON) {
							kouka[i] /= 2;
						}// いまひとつ
						if (enetype[j] == Pokemon.Type.GROUND) {
							kouka[i] *= 0;
						}// 効果Pokemon.Type.NORMALし
						break;
					case ICE:
						if (enetype[j] == Pokemon.Type.GRASS
								|| enetype[j] == Pokemon.Type.GROUND
								|| enetype[j] == Pokemon.Type.FLYING
								|| enetype[j] == Pokemon.Type.DRAGON) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.FIRE
								|| enetype[j] == Pokemon.Type.WATER
								|| enetype[j] == Pokemon.Type.ICE
								|| enetype[j] == Pokemon.Type.STEEL) {
							kouka[i] /= 2;
						}// いまひとつ
						break;

					case FIGHTING:
						if (enetype[j] == Pokemon.Type.NORMAL
								|| enetype[j] == Pokemon.Type.ICE
								|| enetype[j] == Pokemon.Type.ROCK
								|| enetype[j] == Pokemon.Type.DARK
								|| enetype[j] == Pokemon.Type.STEEL) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.POISON
								|| enetype[j] == Pokemon.Type.FLYING
								|| enetype[j] == Pokemon.Type.PSYCHIC
								|| enetype[j] == Pokemon.Type.BUG
								|| enetype[j] == Pokemon.Type.FAIRY) {
							kouka[i] /= 2;
						}// いまひとつ
						if (enetype[j] == Pokemon.Type.GHOST) {
							kouka[i] *= 0;
						}// 効果Pokemon.Type.NORMALし
						break;

					case POISON:
						if (enetype[j] == Pokemon.Type.GRASS
								|| enetype[j] == Pokemon.Type.FAIRY) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.POISON
								|| enetype[j] == Pokemon.Type.GROUND
								|| enetype[j] == Pokemon.Type.ROCK
								|| enetype[j] == Pokemon.Type.GHOST) {
							kouka[i] /= 2;
						}// いまひとつ
						if (enetype[j] == Pokemon.Type.STEEL) {
							kouka[i] *= 0;
						}// 効果Pokemon.Type.NORMALし
						break;

					case GROUND:
						if (enetype[j] == Pokemon.Type.FIRE
								|| enetype[j] == Pokemon.Type.ELECTRIC
								|| enetype[j] == Pokemon.Type.POISON
								|| enetype[j] == Pokemon.Type.ROCK
								|| enetype[j] == Pokemon.Type.STEEL) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.GRASS
								|| enetype[j] == Pokemon.Type.BUG) {
							kouka[i] /= 2;
						}// いまひとつ
						if (enetype[j] == Pokemon.Type.FLYING) {
							kouka[i] *= 0;
						}// 効果Pokemon.Type.NORMALし
						break;

					case FLYING:
						if (enetype[j] == Pokemon.Type.GRASS
								|| enetype[j] == Pokemon.Type.FIGHTING
								|| enetype[j] == Pokemon.Type.BUG) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.ELECTRIC
								|| enetype[j] == Pokemon.Type.ROCK
								|| enetype[j] == Pokemon.Type.STEEL) {
							kouka[i] /= 2;
						}// いまひとつ
						break;

					case PSYCHIC:
						if (enetype[j] == Pokemon.Type.FIGHTING
								|| enetype[j] == Pokemon.Type.POISON) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.PSYCHIC
								|| enetype[j] == Pokemon.Type.STEEL) {
							kouka[i] /= 2;
						}// いまひとつ
						if (enetype[j] == Pokemon.Type.DARK) {
							kouka[i] *= 0;
						}// 効果Pokemon.Type.NORMALし
						break;

					case BUG:
						if (enetype[j] == Pokemon.Type.GRASS
								|| enetype[j] == Pokemon.Type.PSYCHIC
								|| enetype[j] == Pokemon.Type.DARK) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.FIRE
								|| enetype[j] == Pokemon.Type.FIGHTING
								|| enetype[j] == Pokemon.Type.POISON
								|| enetype[j] == Pokemon.Type.FLYING
								|| enetype[j] == Pokemon.Type.GHOST
								|| enetype[j] == Pokemon.Type.STEEL
								|| enetype[j] == Pokemon.Type.FAIRY) {
							kouka[i] /= 2;
						}// いまひとつ
						break;

					case ROCK:
						if (enetype[j] == Pokemon.Type.FIRE
								|| enetype[j] == Pokemon.Type.ICE
								|| enetype[j] == Pokemon.Type.FLYING
								|| enetype[j] == Pokemon.Type.BUG) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.FIGHTING
								|| enetype[j] == Pokemon.Type.GROUND
								|| enetype[j] == Pokemon.Type.STEEL) {
							kouka[i] /= 2;
						}// いまひとつ
						break;

					case GHOST:
						if (enetype[j] == Pokemon.Type.PSYCHIC
								|| enetype[j] == Pokemon.Type.GHOST) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.DARK) {
							kouka[i] /= 2;
						}// いまひとつ
						if (enetype[j] == Pokemon.Type.NORMAL) {
							kouka[i] *= 0;
						}// 効果Pokemon.Type.NORMALし
						break;

					case DRAGON:
						if (enetype[j] == Pokemon.Type.DRAGON) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.STEEL) {
							kouka[i] /= 2;
						}// いまひとつ
						if (enetype[j] == Pokemon.Type.FAIRY) {
							kouka[i] *= 0;
						}// 効果Pokemon.Type.NORMALし
						break;

					case DARK:
						if (enetype[j] == Pokemon.Type.PSYCHIC
								|| enetype[j] == Pokemon.Type.GHOST) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.FIGHTING
								|| enetype[j] == Pokemon.Type.DARK
								|| enetype[j] == Pokemon.Type.FAIRY) {
							kouka[i] /= 2;
						}// いまひとつ
						break;

					case STEEL:
						if (enetype[j] == Pokemon.Type.ICE
								|| enetype[j] == Pokemon.Type.ROCK
								|| enetype[j] == Pokemon.Type.FAIRY) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.FIRE
								|| enetype[j] == Pokemon.Type.WATER
								|| enetype[j] == Pokemon.Type.ELECTRIC
								|| enetype[j] == Pokemon.Type.STEEL) {
							kouka[i] /= 2;
						}// いまひとつ
						break;

					case FAIRY:
						if (enetype[j] == Pokemon.Type.FIGHTING
								|| enetype[j] == Pokemon.Type.DRAGON
								|| enetype[j] == Pokemon.Type.DARK) {
							kouka[i] *= 2;
						}// 抜群
						if (enetype[j] == Pokemon.Type.FIRE
								|| enetype[j] == Pokemon.Type.POISON
								|| enetype[j] == Pokemon.Type.STEEL) {
							kouka[i] /= 2;
						}// いまひとつ
						break;
					case NONE:
						kouka[i] = 0;
						break;// 自ポケのタイプがなかったら倍率を0にする
					}

				}
			}

		}
		if (kouka[0] >= kouka[1]) {
			highkouka = kouka[0];
		} else {
			highkouka = kouka[1];
		}

		if (highkouka == 0) {
			effect = EffectRelation.Effect.NOT;
		}
		if (highkouka == 0.25) {
			effect = EffectRelation.Effect.MINIMUM;
		}
		if (highkouka == 0.5) {
			effect = EffectRelation.Effect.NOTVERY;
		}
		if (highkouka == 1) {
			effect = EffectRelation.Effect.NORMAL;
		}
		if (highkouka == 2) {
			effect = EffectRelation.Effect.SUPER;
		}
		if (highkouka == 4) {
			effect = EffectRelation.Effect.HYPER;
		}

		ef.setEffect(effect);

		return ef;// 計算結果の
	}
}
