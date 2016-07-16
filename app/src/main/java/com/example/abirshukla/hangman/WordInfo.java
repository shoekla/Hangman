package com.example.abirshukla.hangman;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by abirshukla on 7/9/16.
 */
public class WordInfo {
    public static ArrayList<String> incorrectWords = new ArrayList<>();

    public static ArrayList<String> wordGuesses = new ArrayList<>();

    public static ArrayList<String> letters = new ArrayList<>();

    public static ArrayList<String> correctLetters = new ArrayList<>();

    public static void sort() {
        Collections.sort(correctLetters);
    }
    public static void filter(String word) {
        for (int i = wordGuesses.size() - 1; i >= 0; i--) {
            try {
                if (word.length() != wordGuesses.get(i).length()) {
                    wordGuesses.remove(i);
                    continue;
                }
                for (int l = 0; l < incorrectWords.size(); l++) {
                    if (wordGuesses.get(i).contains(incorrectWords.get(l))) {
                        wordGuesses.remove(i);
                        continue;
                    }
                }
                for (int w = 0; w < word.length(); w++) {
                    if (word.charAt(w) != '#') {
                        if (wordGuesses.get(i).charAt(w) != word.charAt(w)) {
                            wordGuesses.remove(i);
                            continue;
                        }
                    } else {
                        for (int c = 0; c < correctLetters.size(); c++) {
                            if (wordGuesses.get(i).charAt(w) == correctLetters.get(c).charAt(0)) {
                                wordGuesses.remove(i);
                                continue;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }

       /* for (int i = 0; i < wordGuesses.size();i++) {
            String s = wordGuesses.get(i);
            for (int k = 0; k < s.length();k++) {
                if (word.charAt(k) == '#') {
                    if (!word.contains(Character.toString(s.charAt(k)))) {
                        wordGuesses.remove(i);
                        continue;
                    }
                }
                else {
                    if (word.charAt(k) != s.charAt(k)) {
                        wordGuesses.remove(i);
                        continue;
                    }
                }
            }
        }
        */
    }
    public static String getGuess() {
        for (int i = 0; i < wordGuesses.size();i++) {
            String s = wordGuesses.get(i);
            for (int k = 0; k < s.length();k++) {
                if (!correctLetters.contains(Character.toString(s.charAt(k))) && !incorrectWords.contains(Character.toString(s.charAt(k)))) {
                    return Character.toString(s.charAt(k));
                }
            }

        }
        String l = letters.get(0);
       letters.remove(0);
        return l;
    }



    public static String[] randomWords = {"big","zesty","spectacular","colour","lively","guarded","multiply","scrape","face","bored","befitting","better","abaft","great","rain","continue","nimble","blind","self","stiff","punch","living","open","twist","count","ocean","allow","wave","mark","dinosaurs","cow","creature","regret","hurt","fretful","march","popcorn","thundering","steam","doubtful","greasy","damage","threatening","clever","bump","guide","blink","cat","vast","magic","applaud","haunt","thing","yawn","muddled","assorted","present","yarn","amuck","pop","trousers","geese","friend","mask","move","attend","plants","kneel","furtive","watch","smile","hospitable","grate","woozy","ragged","fabulous","insect","left","nerve","free","wink","rampant","rotten","rule","trust","periodic","lettuce","slave","ritzy","female","shrug","nippy","cowardly","sheet","heady","equable","frantic","courageous","abrasive","pleasant","note","wanting","angle","unbecoming","babies","red","question","drawer","highfalutin","abstracted","flap","mushy","suck","hope","work","trouble","value","laugh","obedient","slip","watery","grubby","imported","step","sheep","tough","important","arrange","humdrum","statement","part","quicksand","wrench","hissing","bear","divide","sun","daily","right","pale","low","thumb","billowy","yielding","bow","teeny-tiny","lively","preach","loutish","silent","sedate","broad","lip","pour","wasteful","sigh","squash","interfere","drown","incandescent","breathe","fetch","suspect","amazing","bolt","pin","abject","test","imagine","smile","odd","next","scared","easy","grape","ten","dust","field","save","nose","slow","voracious","pedal","sprout","box","few","bumpy","common","internal","drip","spot","balance","same","undress","husky","crash","piquant","accidental","town","sassy","kiss","anger","waggish","wound","sudden","stomach","charge","adaptable","workable","sharp","high-pitched","stick","remarkable","tight","carry","calculate","wakeful","apathetic","type","enthusiastic","premium","unusual","possible","intend","flippant","spotty","wrist","brawny","repair","wave","advice","women","milk","spoil","fair","laborer","bedroom","drum","cooperative","reply","long","power","opposite","turn","tired","unknown","glue","obscene","gratis","lame","ambitious","fascinated","hot","stereotyped","slow","sore","wander","dazzling","vegetable","unkempt","tested","subdued","wonder","hollow","shoes","mountain","remove","lush","small","poke","youthful","camera","dashing","profuse","wood","signal","coach","tie","ball","rose","cream","rod","debonair","nondescript","full","radiate","unarmed","curved","penitent","driving","disappear","camp","ship","bury","chalk","drab","crack","spurious","pretty","political","skirt","succeed","books","plastic","waiting","ethereal","prose","pail","tow","truculent","poised","last","grouchy","tongue","round","scarf","paper","windy","devilish","note","enjoy","sincere","warlike","telephone","marked","soak","stroke","crown","ill-fated","succinct","depressed","tax","achiever","tangible","lewd","stranger","roll","question","ground","creator","recess","picayune","post","dusty","relax","giant","tidy","impolite","wiry","compete","thrill","activity","zinc","unadvised","place","whispering","effect","mine","fold","cook","honey","jeans","side","trick","frightening","thirsty","bake","dangerous","whisper","sleepy","sable","party","funny","slim","tacit","pet","umbrella","brief","abnormal","overflow","river","diligent","houses","quiet","bucket","crazy","ahead","harmonious","need","dance","decay","fish","painful","hum","obtain","dust","lying","purpose","oil","illegal","stop","whip","sack","match","juggle","reflective","want","deceive","offer","heavy","fine","crack","cakes","curious","skin","ticket","true","club","beneficial","stupid","rigid","ring","chivalrous","business","invite","agreement","powerful","amount","number","pastoral","efficient","carriage","romantic","cover","door","trail","glamorous","creepy","elastic","grass","cluttered","dusty","interest","improve","tin","clam","pushy","secretary","dull","lumber","large","fruit","harmony","drop","appear","ice","chief","berry","distribution","root","lonely","open","arithmetic","birth","airplane","cherry","dare","control","rhetorical","far-flung","answer","sand","believe","acidic","flashy","kiss","receptive","symptomatic","superficial","boat","wing","half","gruesome","flight","number","yard","surprise","four","craven","pest","outgoing","royal","north","night","memory","jewel","slip","seat","list","ambiguous","kick","shy","bubble","certain","friendly","offbeat","notebook","bare","pollution","calendar","wren","command","scattered","dock","elderly","card","dapper","suppose","communicate","abounding","paddle","talk","useful","box","use","womanly","canvas","wild","adventurous","strip","replace","overconfident","duck","impress","lacking","bomb","bloody","grateful","bashful","cub","explode","aloof","smoggy","join","point","support","curly","park","planes","develop","instinctive","suggest","existence","icky","scare","sidewalk","tank","impossible","murky","star","mice","longing","nappy","paste","chickens","pray","military","suit","meal","sea","direction","quaint","zippy","stain","well-groomed","placid","plot","dog","natural","system","dirty","bait","dry","plausible","dysfunctional","doubt","wise","subsequent","instruct","inform","ban","alert","absorbing","disagree","brown","deranged","wail","behavior","base","attach","hate","bounce","range","jaded","brick","bird","behave","peep","squirrel","smell","omniscient","kindhearted","bitter","downtown","past","worthless","wool","pass","boundless","vulgar","cent","mine","desert","damp","horse","peel","pleasure","board","lie","vagabond","laughable","healthy","humor","remind","previous","misty","tedious","butter","stew","agree","receipt","scarce","learn","somber","charming","frame","clover","kind","crow","oven","aboriginal","chop","trashy","agonizing","strong","flow","obey","wax","miscreant","market","person","beds","respect","slope","guard","pinch","care","tramp","wash","exuberant","tremble","match","imaginary","hysterical","picture","riddle","gorgeous","calculator","six","thoughtless","blow","conscious","one","peck","lighten","dress","badge","hard","shirt","taboo","branch","messy","lock","regret","share","unite","helpless","onerous","grieving","quack","giants","protective","supreme","rake","pigs","ants","rabbit","wretched","lumpy","meddle","ugliest","gainful","veil","earthquake","pie","ruthless","growth","church","cannon","real","dramatic","rightful","quiet","hot","home","quilt","selfish","abusive","fade","tumble","excuse","available","support","classy","extend","honorable","secret","army","tame","low","society","program","guiltless","goofy","stale","flag","stove","embarrass","kittens","general","harbor","word","money","join","hill","waste","lean","crook","knowledgeable","apologise","puzzling","adhesive","flood","solid","calm","boorish","irritate","trip","run","shiny","wrap","throne","month","drain","name","serve","willing","sick","air","writer","purple","cobweb","ready","gabby","hapless","resolute","payment","pancake","chilly","cold","transport","explain","produce","war","book","draconian","interrupt","absorbed","thankful","ruddy","uncle","even","perform","winter","coal","part","cloth","trip","tasteful","painstaking","aunt","uttermost","irate","bag","reason","horses","sturdy","pricey","industrious","curve","committee","soggy","rifle","young","songs","crabby","judicious","exotic","carpenter","limping","spiteful","glorious","glib","rambunctious","terrible","live","gentle","cheese","slap","porter","mint","nail","hellish","tub","order","rhythm","advertisement","invention","uninterested","matter","fresh","addition","juvenile","territory","aspiring","petite","increase","complex","testy","hammer","buzz","heavenly","wide","wiggly","depend","brave","dreary","unaccountable","egg","endurable","move","moldy","outrageous","scrawny","alcoholic","tawdry","flaky","doll","heartbreaking","dress","plantation","measure","witty","pot","hospital","unnatural","irritating","historical","rare","visitor","shaggy","dizzy","weather","magenta","talk","itchy","yell","wandering","bomb","uppity","toothbrush","rat","gaze","powder","earthy","crime","push","prefer","different","careful","dad","puffy","ripe","bang","puncture","title","whistle","staking","educated","thank","crowded","milky","fireman","humorous","bustling","ink","polish","legs","homeless","observant","parcel","fearful","ashamed","flimsy","vanish","government","hurry","empty","stuff","vivacious","mute","temporary","detail","mouth","zephyr","unable","sleep","grease","holistic","house","abortive","vacuous","road","flat","spotted","transport","scientific","forgetful","cause","nut","bleach","energetic","jumbled","recondite","tan","land","steel","majestic","sound","eggs","fumbling","strap","stormy","nest","evasive","chubby","insidious","bat","stitch","faint","tire","wall","rebel","separate","early","overwrought","slimy","plug","strange","loose","quince","level","gather","water","curvy","unsuitable","spiritual","form","roasted","pen"};
}
