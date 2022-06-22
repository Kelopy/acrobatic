package me.kelopy.acrobatic.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class vault implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){

            Inventory vault = Bukkit.createInventory(p, 9, ChatColor.BOLD + "Kelopy's Special Vault ;)");

            ItemStack item1 = new ItemStack(Material.DIAMOND_SWORD, 1);

            item1.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 14);
            item1.addEnchantment(Enchantment.FIRE_ASPECT, 2);

            ItemMeta meta = item1.getItemMeta();
            meta.setDisplayName(ChatColor.GOLD + "Spicy Aspect of the Dragons");
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.setUnbreakable(true);

            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+245 " + ChatColor.YELLOW + "(+20)");
            lore.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+125 " + ChatColor.YELLOW + "(+20) " + ChatColor.DARK_GRAY + "(Spicy +5)");
            lore.add(ChatColor.GRAY + "Crit Chance: " + ChatColor.RED + "+1% " + ChatColor.DARK_GRAY + "(Spicy +1%)");
            lore.add(ChatColor.GRAY + "Crit Damage: " + ChatColor.RED + "+100% " + ChatColor.DARK_GRAY + "(Spicy +50%)");
            lore.add(ChatColor.GRAY + "Attack Speed: " + ChatColor.RED + "+10% " + ChatColor.DARK_GRAY + "(Spicy +10%)");
            lore.add("");
            lore.add(ChatColor.BLUE + "Cleave V, Critical V");
            lore.add(ChatColor.BLUE + "Cubism V, Ender Slayer V");
            lore.add(ChatColor.BLUE + "Execute V, Experience III");
            lore.add(ChatColor.BLUE + "Fire Aspect II, Fire Strike IV");
            lore.add(ChatColor.BLUE + "Giant Killer VI, Impaling III");
            lore.add(ChatColor.BLUE + "Lethality V, Life Steal III");
            lore.add(ChatColor.BLUE + "Looting III, Luck V");
            lore.add(ChatColor.BLUE + "Scavanger III, Sharpness VI");
            lore.add(ChatColor.BLUE + "Telekinesis I, Thunderlord V");
            lore.add(ChatColor.BLUE + "Vamirism V, Venomous V");
            lore.add("");
            lore.add(ChatColor.GOLD + "Item Ability: Dragon Rage " + ChatColor.YELLOW + "" + ChatColor.BOLD + "RIGHT CLICK");
            lore.add(ChatColor.GRAY + "All Monsters in front of you");
            lore.add(ChatColor.GRAY + "take " + ChatColor.GREEN + "700" + ChatColor.GRAY + " damage. Hit");
            lore.add(ChatColor.GRAY + "monsters take large knockback.");
            lore.add(ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.DARK_AQUA + "100");
            lore.add(ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.GREEN + "5s");
            lore.add("");
            lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "LEGENDARY");

            meta.setLore(lore);
            item1.setItemMeta(meta);

            vault.setItem(4, item1);

            p.openInventory(vault);
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1.0f, 1.0f);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Opened &cKelopy&7's special vault &b;)"));

        }else{
            System.out.println("You need to be a player to execute this command.");
        }

        return true;
    }
}
