package com.example.peaceofmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdsmdg.harjot.longshadows.LongShadowsTextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import db.InputContract;
import db.InputDbHelper;

public class MainActivity extends AppCompatActivity {
    Button buttonOpenCard;
    Button buttonPlaner;
    Button buttonCard;
    ImageView imageViewCards;
    LongShadowsTextView massageForCardDay;
    private InputDbHelper mHelper;
    ArrayAdapter<String> adapter;

    private List<Integer> mImageResources = new ArrayList<>();
    private Random finishRandomR = new Random();
    int finishRandom = finishRandomR.nextInt((8)+1);


    public List<Integer> getmImageResources(ImageView imageView) {
        return mImageResources;
    }

    public Drawable setmImageResources(List<Integer> mImageResources) {
        this.mImageResources = mImageResources;
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageResources.add(R.drawable.shut);
        mImageResources.add(R.drawable.mag);
        mImageResources.add(R.drawable.verhovayazhrica);
        mImageResources.add(R.drawable.imperatrica);
        mImageResources.add(R.drawable.imperator);
        mImageResources.add(R.drawable.verhovnyizhrec);
        mImageResources.add(R.drawable.vlublennye);
        mImageResources.add(R.drawable.kolesnica);
        mImageResources.add(R.drawable.sila);
        mImageResources.add(R.drawable.otshelnik);
        mImageResources.add(R.drawable.kolesofortuny);
        mImageResources.add(R.drawable.spravedlivost);
        mImageResources.add(R.drawable.poveshennyi);
        mImageResources.add(R.drawable.smert);
        mImageResources.add(R.drawable.umerennost);
        mImageResources.add(R.drawable.diyavol);
        mImageResources.add(R.drawable.padayushayabashnya);
        mImageResources.add(R.drawable.zvezda);
        mImageResources.add(R.drawable.luna);
        mImageResources.add(R.drawable.solnce);
        mImageResources.add(R.drawable.strashnyisud);
        mImageResources.add(R.drawable.mir);

        massageForCardDay = (LongShadowsTextView) findViewById(R.id.textView1);
        imageViewCards = (ImageView) findViewById(R.id.imageView);
        buttonCard = (Button) findViewById(R.id.meditationsButton);
        buttonOpenCard = (Button) findViewById(R.id.btnOpenCard);
        buttonPlaner = (Button) findViewById(R.id.button_planer);
                buttonOpenCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (finishRandom) {
                            case 1:
                                imageViewCards.setImageResource(R.drawable.shut);
                                massageForCardDay.setText("Ваша карта - шут. " +
                                        "Если человеку в качестве карты дня выпал Шут, то ему предстоит очень много новых и интересных дел. Придется импровизировать, много шутить, быть инициатором и первопроходцем. В этом нет ничего плохого, ведь иногда так полезно снова почувствовать себя беззаботным ребенком, воспринимающим жизнь как веселую игру. В течение дня нужно избегать предвзятости оценок и косности. Для того чтобы день сложился хорошо, нужно подходить ко всем делам творчески и с энтузиазмом. Не страшно, если придется начинать работу заново.");
                                break;
                            case 2:
                                imageViewCards.setImageResource(R.drawable.mag);
                                massageForCardDay.setText("Ваша карта - маг. " +
                                        "Карта Таро говорит о том, что человеку необходимо проявить свою инициативу, ведь он значительно хорошо вооружен, и сможет показать свою логику и благоразумие. Даже если в этот день ему обязательно нужно будет срочно принимать решение, то ничего не помешает ему это сделать. По крайней мере, день очень благоприятный.");
                                break;
                            case 3:
                                imageViewCards.setImageResource(R.drawable.verhovayazhrica);
                                massageForCardDay.setText("Ваша карта - жрица. " +
                                        " Карта Таро говорит о том, что человеку нужно прислушаться к внутреннему голосу и действовать согласно ситуации. В этот день стоит положиться на интуицию. Не следует искать объяснений и оправданий тем вопросам, которые не хочется принимать.Необходимо ценить время, и каждую секунду этого дня. Побудьте с собой, обращайтесь к своему внутреннему голосу.");
                                break;
                            case 4:
                                imageViewCards.setImageResource(R.drawable.kolesnica);
                                massageForCardDay.setText("Ваша карта - колесница. " +
                                        "Сегодня самое время достигать своих целей. И самое главное, сосредоточиться. Если есть какие-то важные и неотложные дела, необходимо их делать именно сегодня. Даже не стоит долго раздумывать, они будут выполнены качественно. Следует двигаться только вперед, преодолевая все препятствия на своем пути.");
                                break;
                            case 5:
                                imageViewCards.setImageResource(R.drawable.imperatrica);
                                massageForCardDay.setText("Ваша карта - императрица. " +
                                        "Карта Таро говорит о том, что эта карта принесет увлекательный день. Возможно, человеку захочется отправиться на природу, чтобы дать энергию и подпитку своему организму и душе. У человека появится достаточно много интересных идей, а также творческих замыслов. То, что долго было неосуществимым, в этот день осуществится.");
                                break;
                            case 6:
                                imageViewCards.setImageResource(R.drawable.imperator);
                                massageForCardDay.setText("Ваша карта - император. " +
                                        "В качестве карты дня Император является хорошим предзнаменованием. Его появление говорит о том, что человеку в этот день будет удаваться все, за что он возьмется, его сил, энергии и решимости хватит на все. Если у него есть какое-либо сложное дело или проблема, решение которой долго откладывалось, надо взяться именно за это. Действовать нужно решительно, но взвешенно и основательно.");
                                break;
                            case 7:
                                imageViewCards.setImageResource(R.drawable.verhovnyizhrec);
                                massageForCardDay.setText("Ваша карта - жрец. " +
                                        "Если вам выпал Верховный Жрец, то это получение толкового, разумного совета, подсказка о выходе из ситуации. Либо человек сам может стать учителем для кого-либо. Но не стоит самоутверждаться за счёт другого.Правила либо ритуалы, которые производились и помогали раньше, уже стали бессмысленны, и пустая болтовня не пригодится. Нужно смотреть внутрь дела, искать там ценности, которые с первого взгляда не видно. Вас могут вовлечь в какой-либо конфликт, но тогда вам лучше всего постараться избежать его.");
                                break;
                            case 8:
                                imageViewCards.setImageResource(R.drawable.vlublennye);
                                massageForCardDay.setText("Ваша карта - влюбленные." +
                                        "Сегодня необходимо принять окончательное решение, независимо от того, связано ли это с профессиональной деятельностью или с какими-то личными делами. Если человек долго в чем-то сомневался или просто не торопил события, то теперь судьба дает ему шанс поставить окончательную точку.Пусть внутренний голос, сердце и ум – подскажут вам правильное решение.");
                                break;
                            case 9:
                                imageViewCards.setImageResource(R.drawable.sila);
                                massageForCardDay.setText("Ваша карта - сила." +
                                        "Как карта дня Сила символизирует увлеченность и успех начинаний. Она рекомендует приложить свои таланты к работе или активизироваться в личном плане. В день, на который выпала такая карта, сил хватит на все.Если же возникнут какие-то проблемы и препятствия, не нужно пугаться. Они будут преодолимы, но действовать надо без агрессии, но решительно, не бояться и в контратаку переходить. Тогда все начинания обязательно закончатся успешно, а противник будет принужден к капитуляции.");
                                break;
                            case 10:
                                imageViewCards.setImageResource(R.drawable.otshelnik);
                                massageForCardDay.setText("Ваша карта - отшельник." +
                                        "Если Отшельник выпал в качестве карты дня, то в этот день следует полагаться, лишь на себя самого. Решения нужно принимать не спеша, взвешенно и именно что самостоятельно. Если имеются важные дела, делать их надо скрупулезно и ответственно, и опять-таки полагаясь исключительно на собственные возможности.Такой день отлично подойдет для ухода за собой, а особенно – для духовной практики, оценки собственной личности, медитаций.");
                                break;
                            case 11:
                                imageViewCards.setImageResource(R.drawable.kolesofortuny);
                                massageForCardDay.setText("Ваша карта - колесо фортуны." +
                                        "Сегодня человека ожидают положительные события в жизни. И что бы ни происходило в судьбе человека, все нужно принимать с благодарностью. Есть возможность в этот день достичь многого, можно сделать первый шаг и проявить инициативу. Могут каким-то образом произойти события, которые будут из прошлой жизни.");
                                break;
                            case 12:
                                imageViewCards.setImageResource(R.drawable.spravedlivost);
                                massageForCardDay.setText("Ваша карта - справедливость." +
                                        "Аркан говорит о том, что необходимо очень хорошо и трезво размышлять над текущими делами. Если разрешается какой-либо конфликт, принимаются какие-либо решения, внимательно и дотошно просчитайте все последствия ваших действий. Просмотрите условия договора,не упускайте мелочей.");
                                break;
                            case 13:
                                imageViewCards.setImageResource(R.drawable.poveshennyi);
                                massageForCardDay.setText("Ваша карта - повешенный." + "Нужно набраться терпения и просто пережить этот день. Попытки как-то повлиять на события и ускорить их ход приведут только к противоположному результату. Лучше потратить время на осмысление положения и разработку планов действий на будущее.\n" +
                                        "Иногда приходится думать о том, чем можно пожертвовать ради того, чтобы разрешить проблему, если нельзя вовсе отказаться от застопорившегося дела или оставить все как есть.");
                                break;
                            case 14:
                                imageViewCards.setImageResource(R.drawable.smert);
                                massageForCardDay.setText("Ваша карта - смерть." + "В этот день для человека происходящее станет пройденным этапом (прошлое). Для кого-то это будет приятной вестью, что наконец-то это произошло и все завершилось, а кому-то не захочется расставаться, ведь это время так много значило для него. Но ничего здесь не поделаешь, нужно смириться с обстоятельствами, и подготовиться к тому, чтобы расстаться с прошлым.");
                                break;
                            case 15:
                                imageViewCards.setImageResource(R.drawable.umerennost);
                                massageForCardDay.setText("Ваша карта - умеренность." + "Этот день можно, по истине, назвать волшебным. У человека произойдут в жизни какие-то новые открытия и события, что-то произойдет, связанное с творчеством. Возможно, у человека получится не только наладить свою жизнь, он сможет в чем-то помочь и другим людям, с удовольствием решит их проблемы.\n" +
                                        "Если есть проблемы в любовных отношениях, то он с легкостью их наладит именно сегодня. ");
                                break;
                            case 16:
                                imageViewCards.setImageResource(R.drawable.diyavol);
                                massageForCardDay.setText("Ваша карта - дьявол." + "В этот день человек увидит теневую сторону своего характера. Возможно, кто-то собьет человека с пути и направит его на неблаговидный поступок, а может он и вовсе изменит своим принципам.\n" +
                                        "Не исключено некое внутреннее побуждение, о котором человек даже не подозревал или просто думал, что уже давно все преодолел. Нельзя подавлять в себе это побуждение, не стоит и винить себя, перебрасывать вину на других. Необходимо найти причину этому импульсу. Человеку предстоит пройти немало испытаний, а скорее, искушений. И главное, чтобы он не вознесся над другими.");
                                break;
                            case 17:
                                imageViewCards.setImageResource(R.drawable.padayushayabashnya);
                                massageForCardDay.setText("Ваша карта - падающая башня." + "Башня предупреждает, хотите вы этого или нет, но ваша жизнь значительно изменится, и лучше всего смириться с наступившими изменениями.\n" +
                                        "Вы можете кричать и впадать в панику, обвинять судьбу, но через некоторое время ваше мнение может измениться. Возможно, что все отношения, которые у вас были, вам уже не нужны, пришла пора от них избавиться.\n" +
                                        "Возможно, что работа, которая у вас была, тоже не нужна для вашего развития. Так что постарайтесь отнестись к ситуации со здравым чувством юмора, спокойно разложить по полочкам и посмотреть, какими плюсами вы располагаете.");
                                break;
                            case 18:
                                imageViewCards.setImageResource(R.drawable.zvezda);
                                massageForCardDay.setText("Ваша карта - звезда." + "Вам нужно ценить представившиеся вам возможности, верить в себя, вот что советует карта. Высшие силы благоволят вам, даже если ваша цель кажется нереальной, план сумасшедшим, не нужно останавливаться, вы поставили себе цель, и ничего им не помешает.\n" +
                                        "Перспективы выйдут за рамки каких-то определённых договорённостей, и человек увидит препятствия, но одновременно увидит, как их преодолеть.");
                                break;
                            case 19:
                                imageViewCards.setImageResource(R.drawable.luna);
                                massageForCardDay.setText("Ваша карта - луна." + "День может человеку показаться неблагоприятным. Причиной этому может послужить дурной сон, который приснился. Не стоит придавать особого значения своим снам, и пугать себя призраками и мистикой.\n" +
                                        "Если перед человеком стоит какое-то важное дело (пусть даже неприятное и сложное), не следует его избегать. Ведь после преодоления страха обязательно последует что-то новое и интересное. Просто нужно собраться с духом, и сделать этот важный и ответственный шаг.");
                                break;
                            case 22:
                                imageViewCards.setImageResource(R.drawable.solnce);
                                massageForCardDay.setText("Ваша карта - солнце." + "День запомнится ярким и счастливым. Либо это будет связано с какой-то победой, а возможно, просто день пройдет без проблем и забот. Следует взяться за какое-нибудь новое занятие, оно станет успешным. Не забывайте и о том, что найдутся люди, которые тоже захотят принять в этом участие. Не отказывайте им в такой возможности.");
                               break;
                            case 20:
                                imageViewCards.setImageResource(R.drawable.strashnyisud);
                                massageForCardDay.setText("Ваша карта - страшный суд." + "В день, на который выпала такая карта, можно решить любую проблему, и неважно, возникла она вчера или десять лет назад. Все может получиться даже само собой. Но от человека требуется внимательность, чтобы уловить правильный момент для действия. Если это получится – успех гарантирован. В определении нужной минуты следует полагаться исключительно на себя, собственное внутреннее чутье.");
                                break;
                            case 21:
                                imageViewCards.setImageResource(R.drawable.mir);
                                massageForCardDay.setText("Ваша карта - мир." + "В этот день, как никогда, человек ощущает силы и гармонию с окружающим миром. Он в полной мере может насладиться этим днем, его спокойными и благоприятными очертаниями.Ему будет казаться, что все идет так, как и должно, либо он просто не придаст значения каким-то помехам. Если человек нуждается в месте, где он может найти себе приют, то карта дня направляет человека сделать этот шаг.");
                                break;
                        }

                        };
                });
    }
    public void toPlaner (View view){
        Intent intent = new Intent(this,Planer.class);
        startActivity(intent);
    }


    public void toMeditations (View view){
        Intent intent = new Intent(this,Meditations.class );
        startActivity(intent);
    }


    public void toStudy (View view){
        Intent intent = new Intent(this,Study.class);
        startActivity(intent);
    }

}
